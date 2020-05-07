package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;

import java.util.List;

public interface StatistikService {

    List<KundeAnzahlLandDTO> findAnzahlVonKundenImLand();
}
