package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;
import de.anna.springboot.model.dto.KundeAnzahlProProduktDTO;
import de.anna.springboot.repository.StatistikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistikServiceImpl implements StatistikService {

    @Autowired
    private StatistikRepository statistikRepository;

    @Override
    public List<KundeAnzahlLandDTO> findAnzahlVonKundenImLand() {

        List<KundeAnzahlLandDTO> anzahlVonKundenImLand = statistikRepository.findAnzahlVonKundenImLand();

        return anzahlVonKundenImLand;
    }

    @Override
    public List<KundeAnzahlProProduktDTO> findAnzahlVonKundenProProdukt() {

        List<KundeAnzahlProProduktDTO> anzahlVonKundenProProdukt = statistikRepository.findAnzahlVonKundenProProdukt();

        return anzahlVonKundenProProdukt;
    }
}
