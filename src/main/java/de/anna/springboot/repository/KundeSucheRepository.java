package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Kunde;

import java.time.LocalDate;
import java.util.List;

public interface KundeSucheRepository {

    List<Kunde> findKunden(String kundeNummer, String steuerId, String nachname, String kundeArt, LocalDate geburtsdatumAB, LocalDate geburtsdatumBIS);
}
