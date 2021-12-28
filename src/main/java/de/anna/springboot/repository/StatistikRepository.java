package de.anna.springboot.repository;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;
import de.anna.springboot.model.dto.KundeAnzahlProProduktDTO;

import java.util.List;

public interface StatistikRepository {

    List<KundeAnzahlLandDTO> findAnzahlVonKundenImLand();

    List<KundeAnzahlProProduktDTO> findAnzahlVonKundenProProdukt();
}
