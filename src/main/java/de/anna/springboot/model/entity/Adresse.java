package de.anna.springboot.model.entity;

import de.anna.springboot.model.enums.AdresseArt;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(generator = "AdresseGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AdresseGenerator", sequenceName = "adresse_id_seq", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LAND")
    private String land;

    @Column(name = "BUNDESLAND")
    private String bundesland;

    @Column(name = "ORT")
    private String ort;

    @Column(name = "POSTLEITZAHL")
    private String postleitzahl;

    @Column(name = "STRASSE")
    private String strasse;

    @Column(name = "HAUS_NR")
    private String hausNr;

    @Column(name = "ADRESSE_ART")
    private AdresseArt adresseArt;

    @ManyToOne
    @JoinColumn(name="KUNDE_ID")
    private Kunde kunde;



    public Adresse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse)) return false;
        Adresse adresse = (Adresse) o;
        return getLand().equals(adresse.getLand()) &&
                getOrt().equals(adresse.getOrt()) &&
                getStrasse().equals(adresse.getStrasse()) &&
                getHausNr().equals(adresse.getHausNr()) &&
                getAdresseArt() == adresse.getAdresseArt();
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

    public AdresseArt getAdresseArt() {
        return adresseArt;
    }

    public void setAdresseArt(AdresseArt adresseArt) {
        this.adresseArt = adresseArt;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getHausNr() {
        return hausNr;
    }

    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
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
