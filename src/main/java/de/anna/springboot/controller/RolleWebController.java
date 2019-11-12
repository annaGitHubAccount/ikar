package de.anna.springboot.controller;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.service.RolleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
public class RolleWebController {

    private static final String ROLLE = "rolle";
    private static final String ROLLE_LIST = "rolleList";
    private static final String KUNDE_LIST = "kundeList";

    @Autowired
    private RolleService rolleService;

    @Autowired
    private KundeService kundeService;


    @GetMapping("/findrollenvonkunde/{id}")
    public String findRollenVonKunde(@PathVariable Long id, Model model){

        List<RolleDTO> rollenVonKunden = rolleService.findByKundeId(id);

        RolleDTO rolleDTO = new RolleDTO();
        rolleDTO.setKundeId(id);

        model.addAttribute(ROLLE_LIST, rollenVonKunden);
        model.addAttribute(ROLLE, rolleDTO);

        return "listeVonRollen";
    }


    @GetMapping("/editrolle/{id}")
    public String editRolle(@PathVariable Long id, Model model){

        RolleDTO rolleDTO = rolleService.findRolleById(id);
        model.addAttribute(ROLLE, rolleDTO);

        return "editRolle";
    }

    @PostMapping("/rolleweiterleitenedit")
    public String rolleWeiterleitenEdit(RolleDTO rolleDTO, Model model){

        model.addAttribute(ROLLE, rolleDTO);
        return "rolleWeiterleitenEdit";
    }

    @PostMapping("/saverolle")
    public String saveRolle(@ModelAttribute(ROLLE) RolleDTO rolleDTO, Model model){

        rolleService.save(rolleDTO);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/kundesucheform/listevonkunden";
    }


    @GetMapping("/deleterolle/{id}/{kundeId}")
    public String deleteRolle(@PathVariable Long id, @PathVariable("kundeId") Long kundeId, Model model){

        rolleService.deleteRolleById(id);

        List<RolleDTO> rollenByKundeId = rolleService.findByKundeId(kundeId);
        RolleDTO rolleDTO = new RolleDTO();
        rolleDTO.setKundeId(kundeId);

        model.addAttribute(ROLLE_LIST, rollenByKundeId);
        model.addAttribute(ROLLE, rolleDTO);

        return "listeVonRollen";
    }

    @PostMapping("/addrole")
    public String addRolle(@ModelAttribute(ROLLE) RolleDTO rolleDTO , Model model){

        model.addAttribute(ROLLE, rolleDTO);

        return "addRole";
    }

    @PostMapping("/rolleweiterleiten")
    public String rolleweiterleiten(@ModelAttribute(ROLLE) RolleDTO rolleDTO, Model model){

        model.addAttribute(ROLLE, rolleDTO);

        return "rolleWeiterleiten";
    }

}
