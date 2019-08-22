package de.anna.springboot.model.dto;

import de.anna.springboot.model.enums.AdresseArt;

public class AdresseDTO {

    private Long id;
    private String land;
    private String ort;
    private String strasse;
    private String hausNr;
    private AdresseArt adresseArt;
    private KundeDTO kundeDTO;


    public AdresseDTO() {
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
}
