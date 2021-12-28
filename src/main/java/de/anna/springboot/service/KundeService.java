package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;

import java.time.LocalDate;
import java.util.List;

public interface KundeService {

    void save(KundeDTO kundeDTO);

    List<KundeDTO> findAll();

    List<KundeZeileDTO> findAllKundeZeileDTO();

    List<KundeZeileDTO> findAllKundeZeileDTOByNachname(String nachname);

    KundeDTO findKundeById(Long id);

    void deleteKundeById(Long id);

    List<KundeDTO> findKundenByNachname(String nachname);

    List<KundeZeileDTO> findeKunden(String kundeNummer, String steuerId, String nachname, String kundeArt, LocalDate geburtsdatumAB, LocalDate geburtsdatumBIS);

}
