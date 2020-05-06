package de.anna.springboot.model.entity;

import de.anna.springboot.model.enums.KundeArt;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Kunde {


    @Id
    @GeneratedValue(generator = "KundeGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "KundeGenerator", sequenceName = "kunde_id_seq", allocationSize = 1)
    private Long id;

    private String kundeNummer;

    private String steuerId;

    private String name;

    private String nachname;

    private LocalDate birthDate;

    @Column(name = "KUNDE_ART")
    private KundeArt kundeArt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kunde")
    private List<Adresse> adresseList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kunde")
    private List<Produkt> produktList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kunde")
    private List<Rolle> rolleList;


    public Kunde() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunde)) return false;
        Kunde kunde = (Kunde) o;
        return getSteuerId().equals(kunde.getSteuerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSteuerId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSteuerId() {
        return steuerId;
    }

    public void setSteuerId(String steuerId) {
        this.steuerId = steuerId;
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

    public List<Adresse> getAdresseList() {
        return adresseList;
    }

    public void setAdresseList(List<Adresse> adresseList) {
        this.adresseList = adresseList;
    }

    public List<Produkt> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<Produkt> produktList) {
        this.produktList = produktList;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public void setKundeNummer(String kundeNummer) {
        this.kundeNummer = kundeNummer;
    }

    public List<Rolle> getRolleList() {
        return rolleList;
    }

    public void setRolleList(List<Rolle> rolleList) {
        this.rolleList = rolleList;
    }
}
