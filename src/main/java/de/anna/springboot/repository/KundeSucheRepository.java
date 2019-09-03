package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Kunde;
import java.util.List;

public interface KundeSucheRepository {

    List<Kunde> findKunden(String steuerId, String nachname, String kundeArt);
}
