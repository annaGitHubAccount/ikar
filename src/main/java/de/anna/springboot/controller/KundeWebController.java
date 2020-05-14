package de.anna.springboot.controller;

import de.anna.springboot.controller.helper.ButtonNachLinksHelperVonProdukt;
import de.anna.springboot.controller.helper.ButtonNachRechtsHelperVonProdukt;
import de.anna.springboot.controller.helper.RolleDTOHelper;
import de.anna.springboot.model.assembler.KundeDTOKundeFormAssembler;
import de.anna.springboot.model.assembler.ProduktStammdatenDTOProduktDTOAssembler;
import de.anna.springboot.model.dto.*;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.model.validator.KundeFormValidator;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.service.LandService;
import de.anna.springboot.service.ProduktStammdatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/web")
public class KundeWebController {

    private static final String KUNDE_FORM = "kundeForm";
    private static final String KUNDE_LIST = "kundeList";
    private static final String PRODUKT_STAMMDATEN_LIST = "produktStammdatenList";
    private static final String PRODUKT_LIST = "produktList";

    @Autowired
    private KundeService kundeService;

    @Autowired
    private KundeFormValidator kundeFormValidator;

    @Autowired
    private ProduktStammdatenService produktStammdatenService;

    @Autowired
    private ButtonNachRechtsHelperVonProdukt buttonNachRechtsHelperVonProdukt;

    @Autowired
    private ButtonNachLinksHelperVonProdukt buttonNachLinksHelperVonProdukt;

    @Autowired
    private RolleDTOHelper rolleDTOHelper;

    @Autowired
    private LandService landService;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(kundeFormValidator);
    }



    @GetMapping("/addkunde")
    public String kundeFormularZeigen(Model model, HttpServletRequest request) {

        KundeForm kundeForm = new KundeForm();

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        List<ProduktDTO> produktStammdatenToProduktDTOList = ProduktStammdatenDTOProduktDTOAssembler.convertProduktStammdatenDTOToProduktDTO(produktStammdatenDTOList);
        List<LandDTO> landDTOList = landService.findAll();

        kundeForm.setProduktStammdatenList(produktStammdatenToProduktDTOList);
        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());
        kundeForm.setLandDTOList(landDTOList);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenToProduktDTOList);
        request.getSession().setAttribute(PRODUKT_LIST, new ArrayList<>());

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "addKunde";
    }


    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, @Valid @ModelAttribute(KUNDE_FORM) KundeForm kundeForm, BindingResult resultOfValidation, HttpServletRequest request) {

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        LandDTO landDTOMeldeanschrift = landService.findLandBySymbol(kundeForm.getLandVonMeldeanschrift());
        kundeForm.setLandVonMeldeanschriftName(landDTOMeldeanschrift.getName());
        LandDTO landDTOPostanschrift = landService.findLandBySymbol(kundeForm.getLandVonPostanschrift());
        kundeForm.setLandVonPostanschriftName(landDTOPostanschrift.getName());
        List<LandDTO> landDTOList = landService.findAll();
        kundeForm.setLandDTOList(landDTOList);

        if (resultOfValidation.hasErrors()) {

            setzenProduktStammdatenUndProduktenImKundeForm(kundeForm, request);
            model.addAttribute(KUNDE_FORM, kundeForm);
            return "addKunde";

        } else {

            setzenProduktStammdatenUndProduktenImKundeForm(kundeForm, request);
            model.addAttribute(KUNDE_FORM, kundeForm);
            return "kundeWeiterleiten";
        }
    }

    private void setzenProduktStammdatenUndProduktenImKundeForm(@ModelAttribute(KUNDE_FORM) @Valid KundeForm kundeForm, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktStammdatenListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_LIST);

        kundeForm.setProduktStammdatenList(produktStammdatenListFromSession);
        kundeForm.setProduktList(produktListFromSession);
    }


    @PostMapping("/buttonnachrechts")
    public String bedienebuttonNachRechts(Model model, KundeForm kundeForm, HttpServletRequest request) {

        List<LandDTO> landDTOList = landService.findAll();

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktStammdatenListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_LIST);

        List<String> produktStammdatenGewaehlteListFromFormular = kundeForm.getProduktStammdatenGewaehlteList();

        List<ProduktDTO> produktStammdatenListUpdated = buttonNachRechtsHelperVonProdukt.loescheAusgewaehlteProduktStammdatenVonProduktStammdatenList(
                produktStammdatenListFromSession, produktStammdatenGewaehlteListFromFormular);

        List<ProduktDTO> produktListUpdated = buttonNachRechtsHelperVonProdukt.fuegeAusgewaehlteProduktStammdatenToProduktListHinzu(
                produktStammdatenListFromSession, produktStammdatenGewaehlteListFromFormular);

        produktListFromSession.addAll(produktListUpdated);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());
        kundeForm.setProduktStammdatenList(produktStammdatenListUpdated);
        kundeForm.setProduktList(produktListFromSession);
        kundeForm.setLandDTOList(landDTOList);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenListUpdated);
        request.getSession().setAttribute(PRODUKT_LIST, produktListFromSession);

        model.addAttribute(KUNDE_FORM, kundeForm);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }
    }


    @PostMapping("/buttonnachlinks")
    public String bedienebuttonNachLinks(Model model, KundeForm kundeForm, HttpServletRequest request) {

        List<LandDTO> landDTOList = landService.findAll();

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktStammdatenListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_LIST);

        List<String> produktAusgewaehlteListFromFormular = kundeForm.getProduktGewaehlteList();

        List<ProduktDTO> produktDTOListUpdated = buttonNachLinksHelperVonProdukt.loescheAusgewaehlteProdukteFromFormularAusProduktList(produktListFromSession, produktAusgewaehlteListFromFormular);

        List<ProduktDTO> produktStammdatenListUpdated = buttonNachLinksHelperVonProdukt.fuegeAusgewaehlteProduktListFromFormularToProduktStammdatenListHinzu(produktListFromSession, produktAusgewaehlteListFromFormular);

        produktStammdatenListFromSession.addAll(produktStammdatenListUpdated);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());
        kundeForm.setProduktStammdatenList(produktStammdatenListFromSession);
        kundeForm.setProduktList(produktDTOListUpdated);
        kundeForm.setLandDTOList(landDTOList);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenListFromSession);
        request.getSession().setAttribute(PRODUKT_LIST, produktDTOListUpdated);

        model.addAttribute(KUNDE_FORM, kundeForm);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }
    }


    @PostMapping("/savekunde")
    public String saveKunde(@ModelAttribute(KUNDE_FORM) KundeForm kundeForm, Model model, HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_LIST);
        kundeForm.setProduktList(produktListFromSession);

        KundeDTO kundeDTO = KundeDTOKundeFormAssembler.mapKundeFormToKundeDTO(kundeForm);
        kundeService.save(kundeDTO);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/kundesucheform/listevonkunden";
    }


    @GetMapping("/editkunde/{id}")
    public String editKunde(@PathVariable Long id, Model model, HttpServletRequest request) {

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        List<ProduktDTO> produktStammdatenList = ProduktStammdatenDTOProduktDTOAssembler.convertProduktStammdatenDTOToProduktDTO(produktStammdatenDTOList);

        KundeDTO kundeDTOById = kundeService.findKundeById(id);
        List<ProduktDTO> produktDTOListVonKunden = kundeDTOById.getProduktDTOList();

        produktStammdatenList.removeAll(produktDTOListVonKunden);

        KundeForm kundeForm = KundeDTOKundeFormAssembler.mapKundeDTOToKundeForm(kundeDTOById);

        List<LandDTO> landDTOList = landService.findAll();
        kundeForm.setLandDTOList(landDTOList);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());
        kundeForm.setProduktStammdatenList(produktStammdatenList);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenList);
        request.getSession().setAttribute(PRODUKT_LIST, produktDTOListVonKunden);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "editKunde";
    }


    @PostMapping("/kundeweiterleitenedit")
    public String kundeWeiterleitenEdit(Model model, KundeForm kundeForm, HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktStammdatenListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_LIST);

        LandDTO landDTOMeldeanschrift = landService.findLandBySymbol(kundeForm.getLandVonMeldeanschrift());
        kundeForm.setLandVonMeldeanschriftName(landDTOMeldeanschrift.getName());
        LandDTO landDTOPostanschrift = landService.findLandBySymbol(kundeForm.getLandVonPostanschrift());
        kundeForm.setLandVonPostanschriftName(landDTOPostanschrift.getName());
        List<LandDTO> landDTOList = landService.findAll();
        kundeForm.setLandDTOList(landDTOList);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());
        kundeForm.setProduktStammdatenList(produktStammdatenListFromSession);
        kundeForm.setProduktList(produktListFromSession);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenListFromSession);
        request.getSession().setAttribute(PRODUKT_LIST, produktListFromSession);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "kundeWeiterleitenEdit";
    }


    @GetMapping("/deletekunde/{id}")
    public String deleteKunde(@PathVariable Long id, Model model) {

        kundeService.deleteKundeById(id);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/kundesucheform/listevonkunden";
    }
}
