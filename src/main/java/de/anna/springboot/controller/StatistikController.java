package de.anna.springboot.controller;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;
import de.anna.springboot.model.dto.KundeAnzahlProProduktDTO;
import de.anna.springboot.service.StatistikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web")
public class StatistikController {

    @Autowired
    StatistikService statistikService;

    private static final String ANZAHL_VON_KUNDEN_IM_LAND = "anzahlVonKundenImLand";
    private static final String ANZAHL_VON_KUNDEN_PRO_PRODUKT = "anzahlVonKundenProProdukt";


    @GetMapping("/findanzahlvonkundenimland")
    public String findAnzahlVonKundenImLand(Model model) {

        List<KundeAnzahlLandDTO> anzahlVonKundenImLandList = statistikService.findAnzahlVonKundenImLand();
        model.addAttribute(ANZAHL_VON_KUNDEN_IM_LAND, anzahlVonKundenImLandList);

        List<KundeAnzahlProProduktDTO> anzahlVonKundenProProduktList = statistikService.findAnzahlVonKundenProProdukt();
        model.addAttribute(ANZAHL_VON_KUNDEN_PRO_PRODUKT, anzahlVonKundenProProduktList);

        return "kundeStatistik";
    }

}
