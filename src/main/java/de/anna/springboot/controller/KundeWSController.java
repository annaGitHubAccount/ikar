package de.anna.springboot.controller;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.webantwort.KundeListServiceAntwort;
import de.anna.springboot.webantwort.KundeServiceAntwort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json", value = "/ws")
public class KundeWSController {

    @Autowired
    private KundeService kundeService;


    @PostMapping("/addkunde")
    public KundeServiceAntwort addKunde(@RequestBody KundeDTO kundeDTO) {

        try {
            kundeService.save(kundeDTO);

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

}
