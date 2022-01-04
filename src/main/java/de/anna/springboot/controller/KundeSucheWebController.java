package de.anna.springboot.controller;

import de.anna.springboot.model.assembler.KundeDTOToKundeRootDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeRootDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeSucheForm;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.util.DateUtils;
import de.anna.springboot.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ikar/kundesucheform")
public class KundeSucheWebController {

    Logger logger = LoggerFactory.getLogger(KundeSucheWebController.class);

    @Autowired
    private KundeService kundeService;

    private static final String KUNDE_LIST = "kundeList";


    @RequestMapping("/listevonkunden")
    public String listeVonKunden(Model model, HttpServletRequest request) {

        KundeSucheForm kundeSucheForm = new KundeSucheForm();
        kundeSucheForm.setKundeArtMap(KundeArt.convertKundeArtEnumToKodeTextMap());

        List<KundeZeileDTO> kundeZeileDTOList = kundeService.findAllKundeZeileDTO();

        request.getSession().setAttribute(KUNDE_LIST, kundeZeileDTOList);

        model.addAttribute(KUNDE_LIST, kundeZeileDTOList);
        model.addAttribute("kundeSucheForm", kundeSucheForm);

        return "listeVonKunden";
    }

    @PostMapping("/resetbutton")
    public String bedieneResetButton(KundeSucheForm kundeSucheForm, Model model) {

        kundeSucheForm.setSteuerId("");
        kundeSucheForm.setNachname("");
        kundeSucheForm.setKundeArtMap(KundeArt.convertKundeArtEnumToKodeTextMap());
        kundeSucheForm.setKundeArt("");
        kundeSucheForm.setGeburtsdatumAB("");
        kundeSucheForm.setGeburtsdatumBIS("");
        kundeSucheForm.setKundeNummer(null);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/ikar/kundesucheform/listevonkunden";
    }


    @PostMapping("/findekunden")
    public String findeKunden(@ModelAttribute("kundeSucheForm") @Valid KundeSucheForm kundeSucheForm, BindingResult resultOfValidation, Model model, HttpServletRequest request) {

        if (resultOfValidation.hasErrors()) {

            model.addAttribute("kundeSucheForm", kundeSucheForm);
            return "listeVonKunden";

        } else {

            kundeSucheForm.setKundeArtMap(KundeArt.convertKundeArtEnumToKodeTextMap());

            String steuerId = kundeSucheForm.getSteuerId();
            String nachname = kundeSucheForm.getNachname();
            String kundeArt = kundeSucheForm.getKundeArt();
            String geburtsdatumAB = kundeSucheForm.getGeburtsdatumAB();
            String geburtsdatumBIS = kundeSucheForm.getGeburtsdatumBIS();
            String kundeNummer = kundeSucheForm.getKundeNummer();

            LocalDate geburtsdatumABlocalDate = null;
            LocalDate geburtsdatumBISlocalDate = null;

            if (!StringUtils.isEmpty(geburtsdatumAB)) {
                geburtsdatumABlocalDate = DateUtils.stringToLocalDate(geburtsdatumAB);
            }

            if (!StringUtils.isEmpty(geburtsdatumBIS)) {
                geburtsdatumBISlocalDate = DateUtils.stringToLocalDate(geburtsdatumBIS);
            }

            List<KundeZeileDTO> kundeZeileDTOList = kundeService.findeKunden(kundeNummer, steuerId, nachname, kundeArt, geburtsdatumABlocalDate, geburtsdatumBISlocalDate);

            request.getSession().setAttribute(KUNDE_LIST, kundeZeileDTOList);

            model.addAttribute(KUNDE_LIST, kundeZeileDTOList);
            model.addAttribute("kundeSucheForm", kundeSucheForm);

            return "listeVonKunden";
        }
    }


    @PostMapping("/generatexml")
    public void generateXML(KundeSucheForm kundeSucheForm, HttpServletResponse response) {

        Long kundeNUmmerLong = null;
        kundeSucheForm.setKundeArtMap(KundeArt.convertKundeArtEnumToKodeTextMap());

        String steuerId = kundeSucheForm.getSteuerId();
        String nachname = kundeSucheForm.getNachname();
        String kundeArt = kundeSucheForm.getKundeArt();
        String geburtsdatumAB = kundeSucheForm.getGeburtsdatumAB();
        String geburtsdatumBIS = kundeSucheForm.getGeburtsdatumBIS();
        String kundeNummer = kundeSucheForm.getKundeNummer();

        LocalDate geburtsdatumABlocalDate = null;
        LocalDate geburtsdatumBISlocalDate = null;

        if (geburtsdatumAB != null && !geburtsdatumAB.isEmpty()) {
            geburtsdatumABlocalDate = DateUtils.stringToLocalDate(geburtsdatumAB);
        }

        if (geburtsdatumBIS != null && !geburtsdatumBIS.isEmpty()) {
            geburtsdatumBISlocalDate = DateUtils.stringToLocalDate(geburtsdatumBIS);
        }

        List<KundeZeileDTO> kundeZeileDTOList = kundeService.findeKunden(kundeNummer, steuerId, nachname, kundeArt, geburtsdatumABlocalDate, geburtsdatumBISlocalDate);

        KundeRootDTO kundeRootDTO = KundeDTOToKundeRootDTOAssembler.convertKundeZeileListDTOToKundeRootDTO(kundeZeileDTOList);

        response.setContentType("text/xml");
        response.setHeader("Content-disposition", "attachment; filename=kunden_daten.xml");

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(KundeRootDTO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(kundeRootDTO, response.getOutputStream());

            response.getOutputStream().flush();

        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);

        }
    }


    @GetMapping("/generatexmllistevonkunden")
    public void generateXMLlisteVonKunden(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("text/xml");
        response.setHeader("Content-disposition", "attachment; filename=kunden_daten.xml");

        generateXMLListeVonKunden(request, response.getOutputStream());
    }


    @GetMapping("/generatepdflistevonkunden")
    public void generatePDFlisteVonKunden(HttpServletRequest request, HttpServletResponse response) {

        /*response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=kunden_daten.pdf");

        ByteArrayOutputStream outStreamXML = new ByteArrayOutputStream();

        generateXMLListeVonKunden(request, outStreamXML);


        byte[] outStrByteArray = outStreamXML.toByteArray();

        ByteArrayInputStream inStreamXML = new ByteArrayInputStream(outStrByteArray);

        StreamSource xmlSource = new StreamSource(inStreamXML);

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try {

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, response.getOutputStream());

            TransformerFactory factory = TransformerFactory.newInstance();

            InputStream inputStreamXSL = KundeSucheWebController.class.getResourceAsStream("/templates/kunden_daten.xsl");

            Transformer transformer = factory.newTransformer(new StreamSource(inputStreamXSL));

            Result result = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlSource, result);

            response.getOutputStream().flush();

        } catch (TransformerException | IOException | FOPException e) {
            throw new RuntimeException(e);
        }*/
    }

    //TODO: AP
    private void generateXMLListeVonKunden(HttpServletRequest request, OutputStream outputStream) {

        @SuppressWarnings("unchecked")
        List<KundeZeileDTO> kundenList = (List<KundeZeileDTO>) request.getSession().getAttribute(KUNDE_LIST);

        KundeRootDTO kundeRootDTO = KundeDTOToKundeRootDTOAssembler.convertKundeZeileListDTOToKundeRootDTO(kundenList);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(KundeRootDTO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //Schema XSDschema = schemaFactory.newSchema(new File("D:\\Workspace\\temp\\xmlToXsd\\kunden_daten.xsd"));

            //jaxbMarshaller.setSchema(XSDschema);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(kundeRootDTO, outputStream);

            outputStream.flush();

        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);

        }
    }
}

