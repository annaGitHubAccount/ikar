package de.anna.springboot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.anna.springboot.model.enums.AdresseArt;

import java.util.Objects;

public class AdresseDTO {

    private Long id;
    private String land;
    private String bundesland;
    private String ort;
    private String postleitzahl;
    private String strasse;
    private String hausNr;
    private AdresseArt adresseArt;
    @JsonIgnore
    private KundeDTO kundeDTO;


    public AdresseDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseDTO)) return false;
        AdresseDTO that = (AdresseDTO) o;
        return getLand().equals(that.getLand()) &&
                getOrt().equals(that.getOrt()) &&
                getStrasse().equals(that.getStrasse()) &&
                getHausNr().equals(that.getHausNr()) &&
                getAdresseArt() == that.getAdresseArt();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLand(), getOrt(), getStrasse(), getHausNr(), getAdresseArt());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausNr() {
        return hausNr;
    }

    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
    }

    public AdresseArt getAdresseArt() {
        return adresseArt;
    }

    public void setAdresseArt(AdresseArt adresseArt) {
        this.adresseArt = adresseArt;
    }

    public KundeDTO getKundeDTO() {
        return kundeDTO;
    }

    public void setKundeDTO(KundeDTO kundeDTO) {
        this.kundeDTO = kundeDTO;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }
}
