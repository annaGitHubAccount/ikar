package de.anna.springboot.controller;

import de.anna.springboot.model.assembler.KundeDTOToKundeRootDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeRootDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeSucheForm;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.util.DateUtils;
import org.apache.fop.apps.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/kundesucheform")
public class KundeSucheWebController {

    @Autowired
    private KundeService kundeService;

    private static final String KUNDE_LIST = "kundeList";


    @GetMapping("/listevonkunden")
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

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/kundesucheform/listevonkunden";
    }


    @PostMapping("/findekunden")
    public String findeKunden(KundeSucheForm kundeSucheForm, Model model, HttpServletRequest request) {

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

        List<KundeDTO> kundenList = kundeService.findeKunden(kundeNummer, steuerId, nachname, kundeArt, geburtsdatumABlocalDate, geburtsdatumBISlocalDate);

        request.getSession().setAttribute(KUNDE_LIST, kundenList);

        model.addAttribute(KUNDE_LIST, kundenList);
        model.addAttribute("kundeSucheForm", kundeSucheForm);

        return "listeVonKunden";
    }


    @PostMapping("/generatexml")
    public void generateXML(KundeSucheForm kundeSucheForm, HttpServletResponse response) {

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

        List<KundeDTO> kundenList = kundeService.findeKunden(kundeNummer, steuerId, nachname, kundeArt, geburtsdatumABlocalDate, geburtsdatumBISlocalDate);

        List<KundeZeileDTO> kundeZeileDTOList = KundeDTOToKundeRootDTOAssembler.convertKundeDTOListToKundeZeileDTOList(kundenList);

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

        response.setContentType("application/pdf");
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
        }
    }



    private void generateXMLListeVonKunden(HttpServletRequest request, OutputStream outputStream) {

        @SuppressWarnings("unchecked")
        List<KundeZeileDTO> kundenList = (List<KundeZeileDTO>) request.getSession().getAttribute(KUNDE_LIST);

        KundeRootDTO kundeRootDTO = KundeDTOToKundeRootDTOAssembler.convertKundeZeileListDTOToKundeRootDTO(kundenList);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(KundeRootDTO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(kundeRootDTO, outputStream);

            outputStream.flush();

        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);

        }
    }
}
