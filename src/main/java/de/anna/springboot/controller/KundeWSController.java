package de.anna.springboot.controller;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.webantwort.KundeListServiceAntwort;
import de.anna.springboot.webantwort.KundeServiceAntwort;
import de.anna.springboot.webantwort.KundeZeileListServiceAntwort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(produces = "application/json", value = "/ws")
public class KundeWSController {

    @Autowired
    private KundeService kundeService;


    @PostMapping("/addkunde")
    public KundeServiceAntwort addKunde(@RequestBody KundeDTO kundeDTO, @RequestHeader Map<String, String> headers) {

        // loggen auf die Konsole:
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            kundeService.save(kundeDTO);
            headers.forEach((key, value) -> {
                logger.info(key + ": " + value);
            });

        } catch (Exception exception) {
            return new KundeServiceAntwort(false, exception.getMessage());
        }

        return new KundeServiceAntwort(true, "");
    }


    @GetMapping("/findkunden")
    public KundeListServiceAntwort findKunden() {

        List<KundeDTO> kundeDTOList = new ArrayList<>();
        try {
            kundeDTOList = kundeService.findAll();

        } catch (Exception exception) {
            return new KundeListServiceAntwort(kundeDTOList, false, exception.getMessage());
        }

        return new KundeListServiceAntwort(kundeDTOList, true, "");
    }


    @PostMapping("/savekunde")
    public KundeServiceAntwort saveKunde(@RequestBody KundeDTO kundeDTO) {

        try {
            kundeService.save(kundeDTO);

        } catch (Exception exception) {
            return new KundeServiceAntwort(false, exception.getMessage());
        }

        return new KundeServiceAntwort(true, "");
    }


    @GetMapping("/deletekunde/{id}")
    public KundeServiceAntwort deleteKunde(@PathVariable Long id) {

        try {
            kundeService.deleteKundeById(id);

        } catch (Exception exception) {
            return new KundeServiceAntwort(false, exception.getMessage());
        }

        return new KundeServiceAntwort(true, "");
    }


    // nieladnie, ale dla cwiczenia....
    @PostMapping("/savekundenachname/{id}/{nachname}")
    public KundeServiceAntwort saveKundeNachname(@PathVariable Long id, @PathVariable String nachname) {

        try {

            KundeDTO kundeById = kundeService.findKundeById(id);
            kundeById.setNachname(nachname);
            kundeService.save(kundeById);

        } catch (Exception exception) {
            return new KundeServiceAntwort(false, exception.getMessage());
        }

        return new KundeServiceAntwort(true, "");
    }


    @GetMapping("/findkundenbynachnamen/{nachname}")
    public KundeListServiceAntwort findKundenByNachnamen(@PathVariable String nachname) {

        List<KundeDTO> kundeDTOList = new ArrayList<>();
        try {
            kundeDTOList = kundeService.findKundenByNachname(nachname);

        } catch (Exception exception) {
            return new KundeListServiceAntwort(kundeDTOList, false, exception.getMessage());
        }

        return new KundeListServiceAntwort(kundeDTOList, true, "");
    }

    @GetMapping("/findeallekundezeiledto")
    public KundeZeileListServiceAntwort findeAlleKundeZeileDTO() {

        List<KundeZeileDTO> allKundeZeileDTO = new ArrayList<>();

        try {
            allKundeZeileDTO = kundeService.findAllKundeZeileDTO();

        } catch (Exception exception) {
            return new KundeZeileListServiceAntwort(allKundeZeileDTO, false, exception.getMessage());
        }

        return new KundeZeileListServiceAntwort(allKundeZeileDTO, true, "");
    }

    @GetMapping("/findeallekundezeiledtobynachname/{nachname}")
    public KundeZeileListServiceAntwort findeAlleKundeZeileDTO(@PathVariable String nachname) {

        List<KundeZeileDTO> allKundeZeileDTOByNachname = new ArrayList<>();

        try {
            allKundeZeileDTOByNachname = kundeService.findAllKundeZeileDTOByNachname(nachname);


        } catch (Exception exception) {
            return new KundeZeileListServiceAntwort(allKundeZeileDTOByNachname, false, exception.getMessage());
        }

        return new KundeZeileListServiceAntwort(allKundeZeileDTOByNachname, true, "");
    }
}
