package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;

import java.util.List;

public interface KundeService {

    void save(KundeDTO kundeDTO);

    List<KundeDTO> findAll();

    KundeDTO findKundeById(Long id);

    void deleteKundeById(Long id);

    List<KundeDTO> findKundenByNachname(String nachname);

}
