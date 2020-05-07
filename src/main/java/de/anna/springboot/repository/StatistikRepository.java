package de.anna.springboot.repository;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;

import java.util.List;

public interface StatistikRepository {

    List<KundeAnzahlLandDTO> findAnzahlVonKundenImLand();
}
