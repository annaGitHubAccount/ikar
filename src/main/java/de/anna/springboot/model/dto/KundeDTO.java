package de.anna.springboot.model.dto;

import de.anna.springboot.model.enums.KundeArt;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class KundeDTO {

    private Long id;

    private String kundeNummer;

    private String steuerId;

    private String name;

    private String nachname;

    private LocalDate birthDate;

    private KundeArt kundeArt;

    private List<AdresseDTO> adresseList;

    private List<ProduktDTO> produktDTOList;

    private List<RolleDTO> rolleDTOList;


    public KundeDTO(String name, String nachname) {
        this.name = name;
        this.nachname = nachname;
    }

    public KundeDTO(String steuerId, String name, String nachname) {
        this.steuerId = steuerId;
        this.name = name;
        this.nachname = nachname;
    }


    public KundeDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KundeDTO)) return false;
        KundeDTO kundeDTO = (KundeDTO) o;
        return getSteuerId().equals(kundeDTO.getSteuerId());
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

    public List<AdresseDTO> getAdresseList() {
        return adresseList;
    }

    public void setAdresseList(List<AdresseDTO> adresseList) {
        this.adresseList = adresseList;
    }

    public List<ProduktDTO> getProduktDTOList() {
        return produktDTOList;
    }

    public void setProduktDTOList(List<ProduktDTO> produktDTOList) {
        this.produktDTOList = produktDTOList;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public void setKundeNummer(String kundeNummer) {
        this.kundeNummer = kundeNummer;
    }

    public List<RolleDTO> getRolleDTOList() {
        return rolleDTOList;
    }

    public void setRolleDTOList(List<RolleDTO> rolleDTOList) {
        this.rolleDTOList = rolleDTOList;
    }
}
