package de.anna.springboot.controller;

import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.service.RolleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/web")
public class RolleWebController {

    @Autowired
    private RolleService rolleService;

    private static final String ROLLE_LIST = "rolleList";


    @GetMapping("/findrollenvonkunde/{id}")
    public String findRollenVonKunde(@PathVariable Long id, Model model){

        List<RolleDTO> rollenByKundeId = rolleService.findByKundeId(id);
        model.addAttribute(ROLLE_LIST, rollenByKundeId);

        return "listeVonRollen";
    }

}
