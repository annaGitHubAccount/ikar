package de.anna.springboot.model.dto.xml;

import de.anna.springboot.model.enums.KundeArt;

import java.time.LocalDate;

public class KundeZeileDTO {

    private Long id;

    private String kundeNummer;

    private String steuerId;

    private String name;

    private String nachname;

    private String rolle;

    private LocalDate birthDate;

    private KundeArt kundeArt;

    public KundeZeileDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSteuerId() {
        return steuerId;
    }

    public void setSteuerId(String steuerId) {
        this.steuerId = steuerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public KundeArt getKundeArt() {
        return kundeArt;
    }

    public void setKundeArt(KundeArt kundeArt) {
        this.kundeArt = kundeArt;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public void setKundeNummer(String kundeNummer) {
        this.kundeNummer = kundeNummer;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}
