package de.anna.springboot.controller;

import de.anna.springboot.controller.helper.ButtonNachLinksHelperVonRolle;
import de.anna.springboot.controller.helper.ButtonNachRechtsHelperVonRolle;
import de.anna.springboot.model.assembler.KundeDTOKundeFormAssembler;
import de.anna.springboot.model.assembler.RolleStammdatenToRolleDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.dto.RolleStammdatenDTO;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.service.RolleService;
import de.anna.springboot.service.RolleStammdatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ikar/web")
public class RolleWebController {

    private static final String ROLLE = "rolle";
    private static final String ROLLE_LIST = "rolleList";
    private static final String KUNDE_LIST = "kundeList";
    private static final String KUNDE_FORM = "kundeForm";
    private static final String ROLLE_STAMMDATEN_LIST = "rolleStammdatenList";

    @Autowired
    private RolleService rolleService;

    @Autowired
    private KundeService kundeService;

    @Autowired
    private RolleStammdatenService rolleStammdatenService;

    @Autowired
    private ButtonNachLinksHelperVonRolle buttonNachLinksHelperVonRolle;

    @Autowired
    ButtonNachRechtsHelperVonRolle buttonNachRechtsHelperVonRolle;


    @GetMapping("/findrollenvonkunde/{id}")
    public String findRollenVonKunde(@PathVariable Long id, Model model, HttpServletRequest request) {

        List<RolleDTO> rollenVonKunden = rolleService.findByKundeId(id);

        List<RolleStammdatenDTO> rolleStammdatenList = rolleStammdatenService.findAll();
        List<RolleDTO> rolleList = RolleStammdatenToRolleDTO.convertRolleStammdatenDTOToRolleDTOList(rolleStammdatenList);

        rolleList.removeAll(rollenVonKunden);

        KundeForm kundeForm = new KundeForm();
        kundeForm.setRolleStammdatenList(rolleList);
        kundeForm.setRolleList(rollenVonKunden);
        kundeForm.setKundeId(id);

        request.getSession().setAttribute(ROLLE_STAMMDATEN_LIST, rolleList);
        request.getSession().setAttribute(ROLLE_LIST, rollenVonKunden);

        model.addAttribute(ROLLE_LIST, rollenVonKunden);
        model.addAttribute(KUNDE_FORM, kundeForm);

        return "listeVonRollen";
    }


    @GetMapping("/editrolle/{id}")
    public String editRolle(@PathVariable Long id, Model model) {

        RolleDTO rolleDTO = rolleService.findRolleById(id);
        model.addAttribute(ROLLE, rolleDTO);

        return "editRolle";
    }

    @PostMapping("/rolleweiterleitenedit")
    public String rolleWeiterleitenEdit(RolleDTO rolleDTO, Model model) {

        model.addAttribute(ROLLE, rolleDTO);
        return "rolleWeiterleitenEdit";
    }

    @PostMapping("/saverolle")
    public String saveRolle(@ModelAttribute(KUNDE_FORM) KundeForm kundeForm, Model model, HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<RolleDTO> rolleDTOList = (List<RolleDTO>) request.getSession().getAttribute(ROLLE_LIST);

        KundeDTO kundeDTO = kundeService.findKundeById(kundeForm.getKundeId());
        kundeDTO.setRolleDTOList(rolleDTOList);

        kundeService.save(kundeDTO);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/ikar/kundesucheform/listevonkunden";
    }


    @GetMapping("/deleterolle/{id}/{kundeId}")
    public String deleteRolle(@PathVariable Long id, @PathVariable("kundeId") Long kundeId, Model model) {

        rolleService.deleteRolleById(id);

        List<RolleDTO> rollenByKundeId = rolleService.findByKundeId(kundeId);
        RolleDTO rolleDTO = new RolleDTO();
        rolleDTO.setKundeId(kundeId);

        model.addAttribute(ROLLE_LIST, rollenByKundeId);
        model.addAttribute(ROLLE, rolleDTO);

        return "listeVonRollen";
    }

    @PostMapping("/rolleweiterleiten")
    public String rolleweiterleiten(@ModelAttribute(KUNDE_FORM) KundeForm kundeForm, Model model, HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<RolleDTO> rolleDTOList = (List<RolleDTO>) request.getSession().getAttribute(ROLLE_LIST);

        kundeForm.setRolleList(rolleDTOList);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "rolleWeiterleiten";
    }

    @PostMapping("/rollebuttonnachlinks")
    public String bedienerollebuttonnachrechts(Model model, KundeForm kundeForm, HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<RolleDTO> rolleStammdatenDTOListFromSession = (List<RolleDTO>) request.getSession().getAttribute(ROLLE_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<RolleDTO> rolleDTOListFromSession = (List<RolleDTO>) request.getSession().getAttribute(ROLLE_LIST);

        List<String> rolleGewaehlteListFromForm = kundeForm.getRolleGewaehlteList();
        List<RolleDTO> rolleDTOListFromSessionUpdated = buttonNachLinksHelperVonRolle.loescheAusgewaehlteRollenFromFormularAusRolleList(
                rolleDTOListFromSession, rolleGewaehlteListFromForm);

        List<RolleDTO> rolleStammdatenListUpdated = buttonNachLinksHelperVonRolle.fuegeAusgewaehlteRolleListFromFormularToRolleStammdatenListHinzu(
                rolleDTOListFromSession, rolleGewaehlteListFromForm);

        rolleStammdatenDTOListFromSession.addAll(rolleStammdatenListUpdated);

        setzenVonDatenInKundeFormUndSession(kundeForm, request, rolleStammdatenDTOListFromSession, rolleDTOListFromSessionUpdated);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "listeVonRollen";
    }



    @PostMapping("/rollebuttonnachrechts")
    public String bedienerollebuttonnachlinks(Model model, KundeForm kundeForm, HttpServletRequest request) {

        @SuppressWarnings("unchecked")
        List<RolleDTO> rolleStammdatenDTOListFromSession = (List<RolleDTO>) request.getSession().getAttribute(ROLLE_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<RolleDTO> rolleDTOListFromSession = (List<RolleDTO>) request.getSession().getAttribute(ROLLE_LIST);

        List<String> rolleStammdatenGewaehlteListFromFormular = kundeForm.getRolleStammdatenGewaehlteList();
        List<RolleDTO> rolleStammdatenListUpdated = buttonNachRechtsHelperVonRolle.loescheAusgewaehlteRolleStammdatenVonRolleStammdatenList(
                rolleStammdatenDTOListFromSession, rolleStammdatenGewaehlteListFromFormular);

        List<RolleDTO> rolleDTOListUpdated = buttonNachRechtsHelperVonRolle.fuegeAusgewaehlteRolleStammdatenToRolleListHinzu(
                rolleStammdatenDTOListFromSession, rolleStammdatenGewaehlteListFromFormular);

        rolleDTOListFromSession.addAll(rolleDTOListUpdated);

        setzenVonDatenInKundeFormUndSession(kundeForm, request, rolleStammdatenListUpdated, rolleDTOListFromSession);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "listeVonRollen";
    }

    private void setzenVonDatenInKundeFormUndSession(KundeForm kundeForm, HttpServletRequest request, List<RolleDTO> rolleStammdatenDTOListFromSession,
                                                     List<RolleDTO> rolleDTOListFromSessionUpdated) {

        kundeForm.setRolleStammdatenList(rolleStammdatenDTOListFromSession);
        kundeForm.setRolleList(rolleDTOListFromSessionUpdated);

        request.getSession().setAttribute(ROLLE_STAMMDATEN_LIST, rolleStammdatenDTOListFromSession);
        request.getSession().setAttribute(ROLLE_LIST, rolleDTOListFromSessionUpdated);
    }

}
