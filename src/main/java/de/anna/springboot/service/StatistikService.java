package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;
import de.anna.springboot.model.dto.KundeAnzahlProProduktDTO;

import java.util.List;

public interface StatistikService {

    List<KundeAnzahlLandDTO> findAnzahlVonKundenImLand();

    List<KundeAnzahlProProduktDTO> findAnzahlVonKundenProProdukt();
}
