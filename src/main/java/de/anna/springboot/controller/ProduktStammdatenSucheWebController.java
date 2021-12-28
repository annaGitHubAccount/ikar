package de.anna.springboot.controller;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.form.ProduktStammdatenSucheForm;
import de.anna.springboot.service.ProduktStammdatenService;
import de.anna.springboot.util.StringUtils;
import de.anna.springboot.webservice.IkarWebServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ikar/produktstammdatensucheform")
public class ProduktStammdatenSucheWebController {

    @Autowired
    private ProduktStammdatenService produktStammdatenService;

    private static final String PRODUKT_STAMMDATEN_LIST = "produktStammdatenList";
    private static final String PRODUKT_STAMMDATEN_SUCHE_FORM = "produktStammdatenSucheForm";


    @PostMapping("/findeproduktstammdaten")
    public String findeProduktstammdaten(@ModelAttribute("produktStammdatenSucheForm") @Valid ProduktStammdatenSucheForm produktStammdatenSucheForm, BindingResult resultOfValidation, Model model, HttpServletRequest request) {

        if (resultOfValidation.hasErrors()) {

            produktStammdatenSucheForm.setIsAktivMap(StringUtils.setzenAktivMapWerten());
            model.addAttribute(PRODUKT_STAMMDATEN_SUCHE_FORM, produktStammdatenSucheForm);

        } else {

            produktStammdatenSucheForm.setIsAktivMap(StringUtils.setzenAktivMapWerten());

            String name = produktStammdatenSucheForm.getName();
            String symbol = produktStammdatenSucheForm.getSymbol();
            String aktiv = produktStammdatenSucheForm.getAktiv();
            BigDecimal preisAB = produktStammdatenSucheForm.getPreisAB();
            BigDecimal preisBIS = produktStammdatenSucheForm.getPreisBIS();

            List<ProduktStammdatenDTO> produktStammdatenDTO = produktStammdatenService.findProduktStammdaten(name, preisAB, preisBIS, symbol, convertStringToBoolean(aktiv));

            model.addAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTO);
            model.addAttribute(PRODUKT_STAMMDATEN_SUCHE_FORM, produktStammdatenSucheForm);
            request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTO);

        }
        return "produktStammdatenList";
    }


    @GetMapping("/produktstammdatenlist")
    public String produktStammdatenListZeigen(Model model) {

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        model.addAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOList);

        ProduktStammdatenSucheForm produktStammdatenSucheForm = new ProduktStammdatenSucheForm();
        produktStammdatenSucheForm.setIsAktivMap(StringUtils.setzenAktivMapWerten());
        model.addAttribute(PRODUKT_STAMMDATEN_SUCHE_FORM, produktStammdatenSucheForm);

        return "produktStammdatenList";
    }

    @PostMapping("/resetbutton")
    public String bedieneResetButton(ProduktStammdatenSucheForm produktStammdatenSucheForm, Model model) {

        produktStammdatenSucheForm.setAktiv("");
        produktStammdatenSucheForm.setIsAktivMap(null);
        produktStammdatenSucheForm.setName("");
        produktStammdatenSucheForm.setPreisAB(null);
        produktStammdatenSucheForm.setPreisBIS(null);
        produktStammdatenSucheForm.setSymbol("");

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        model.addAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOList);

        return "redirect:/ikar/produktstammdatensucheform/produktstammdatenlist";
    }

    private static Boolean convertStringToBoolean(String string) {

        if (string.equals("")) {
            return null;
        }
        if (string.equals("true")) {
            return true;
        }
        if (string.equals("false")) {
            return false;
        }
        return null;
    }
}
