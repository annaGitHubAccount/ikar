package de.anna.springboot.model.form;

import de.anna.springboot.model.dto.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KundeForm {

    private Long id;

    private String kundeNummer;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    @Size(min = 9, max = 9, message = "{steuerId.muss9DigitsHaben}")
    private String steuerId;

    @Size(min = 1, message = "{feld.isErfordelich}")
    private String name;

    @NotNull(message = "{feld.isErfordelich}")
    @Size(min = 1, message = "{feld.isErfordelich}")
    private String nachname;

    @Pattern(regexp = "^\\s*(3[01]|[12][0-9]|0[1-9])\\.(1[012]|0[1-9])\\.((?:19|20)\\d{2})\\s*$", message = "{birthDate.hatKeinErforderlichesFormat}")
    private String birthDate;

    private Map<String, String> kundeArtMap = new LinkedHashMap<>();

    private String kundeArt;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String landVonMeldeanschrift;

    private String landVonMeldeanschriftName;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String bundeslandVonMeldeanschrift;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String ortVonMeldeanschrift;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    @Pattern(regexp = "[0-9]{5}", message = "{postleitzahlVonMeldeanschrift.muss5Zifferhaben}")
    private String postleitzahlVonMeldeanschrift;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String strasseVonMeldeanschrift;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String hausNrVonMeldeanschrift;

    private Boolean postanschriftAktiv;
    private String landVonPostanschrift;
    private String landVonPostanschriftName;
    private String bundeslandVonPostanschrift;
    private String ortVonPostanschrift;
    private String postleitzahlVonPostanschrift;
    private String strasseVonPostanschrift;
    private String hausNrVonPostanschrift;

    private List<String> produktStammdatenList = new ArrayList<>();

    private List<String> produktList = new ArrayList<>();

    private List<RolleDTO> rolleStammdatenList = new ArrayList<>();
    private List<String> rolleStammdatenGewaehlteList = new ArrayList<>();

    private List<RolleDTO> rolleList = new ArrayList<>();
    private List<String> rolleGewaehlteList = new ArrayList<>();

    private String rolle;

    private Long kundeId;

    private List<LandDTO> landDTOList = new ArrayList<>();

    private List<BundeslandDTO> bundeslandDTOList = new ArrayList<>();

    private List<OrtDTO> ortDTOList = new ArrayList<>();

    private List<LandDTO> landDTOListPostanschrift = new ArrayList<>();

    private List<BundeslandDTO> bundeslandDTOListPostanschrift = new ArrayList<>();

    private List<OrtDTO> ortDTOListPostanschrift = new ArrayList<>();


    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLandVonMeldeanschrift() {
        return landVonMeldeanschrift;
    }

    public void setLandVonMeldeanschrift(String landVonMeldeanschrift) {
        this.landVonMeldeanschrift = landVonMeldeanschrift;
    }

    public String getOrtVonMeldeanschrift() {
        return ortVonMeldeanschrift;
    }

    public void setOrtVonMeldeanschrift(String ortVonMeldeanschrift) {
        this.ortVonMeldeanschrift = ortVonMeldeanschrift;
    }

    public String getStrasseVonMeldeanschrift() {
        return strasseVonMeldeanschrift;
    }

    public void setStrasseVonMeldeanschrift(String strasseVonMeldeanschrift) {
        this.strasseVonMeldeanschrift = strasseVonMeldeanschrift;
    }

    public String getHausNrVonMeldeanschrift() {
        return hausNrVonMeldeanschrift;
    }

    public void setHausNrVonMeldeanschrift(String hausNrVonMeldeanschrift) {
        this.hausNrVonMeldeanschrift = hausNrVonMeldeanschrift;
    }

    public String getLandVonPostanschrift() {
        return landVonPostanschrift;
    }

    public void setLandVonPostanschrift(String landVonPostanschrift) {
        this.landVonPostanschrift = landVonPostanschrift;
    }

    public String getOrtVonPostanschrift() {
        return ortVonPostanschrift;
    }

    public void setOrtVonPostanschrift(String ortVonPostanschrift) {
        this.ortVonPostanschrift = ortVonPostanschrift;
    }

    public String getStrasseVonPostanschrift() {
        return strasseVonPostanschrift;
    }

    public void setStrasseVonPostanschrift(String strasseVonPostanschrift) {
        this.strasseVonPostanschrift = strasseVonPostanschrift;
    }

    public String getHausNrVonPostanschrift() {
        return hausNrVonPostanschrift;
    }

    public void setHausNrVonPostanschrift(String hausNrVonPostanschrift) {
        this.hausNrVonPostanschrift = hausNrVonPostanschrift;
    }

    public Map<String, String> getKundeArtMap() {
        return kundeArtMap;
    }

    public void setKundeArtMap(Map<String, String> kundeArtMap) {
        this.kundeArtMap = kundeArtMap;
    }

    public String getKundeArt() {
        return kundeArt;
    }

    public void setKundeArt(String kundeArt) {
        this.kundeArt = kundeArt;
    }


    public List<String> getProduktStammdatenList() {
        return produktStammdatenList;
    }

    public void setProduktStammdatenList(List<String> produktStammdatenList) {
        this.produktStammdatenList = produktStammdatenList;
    }

    public List<String> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<String> produktList) {
        this.produktList = produktList;
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

    public List<RolleDTO> getRolleList() {
        return rolleList;
    }

    public void setRolleList(List<RolleDTO> rolleList) {
        this.rolleList = rolleList;
    }

    public List<String> getRolleGewaehlteList() {
        return rolleGewaehlteList;
    }

    public void setRolleGewaehlteList(List<String> rolleGewaehlteList) {
        this.rolleGewaehlteList = rolleGewaehlteList;
    }

    public List<RolleDTO> getRolleStammdatenList() {
        return rolleStammdatenList;
    }

    public void setRolleStammdatenList(List<RolleDTO> rolleStammdatenList) {
        this.rolleStammdatenList = rolleStammdatenList;
    }

    public List<String> getRolleStammdatenGewaehlteList() {
        return rolleStammdatenGewaehlteList;
    }

    public void setRolleStammdatenGewaehlteList(List<String> rolleStammdatenGewaehlteList) {
        this.rolleStammdatenGewaehlteList = rolleStammdatenGewaehlteList;
    }

    public String getPostleitzahlVonMeldeanschrift() {
        return postleitzahlVonMeldeanschrift;
    }

    public void setPostleitzahlVonMeldeanschrift(String postleitzahlVonMeldeanschrift) {
        this.postleitzahlVonMeldeanschrift = postleitzahlVonMeldeanschrift;
    }

    public String getPostleitzahlVonPostanschrift() {
        return postleitzahlVonPostanschrift;
    }

    public void setPostleitzahlVonPostanschrift(String postleitzahlVonPostanschrift) {
        this.postleitzahlVonPostanschrift = postleitzahlVonPostanschrift;
    }

    public List<LandDTO> getLandDTOList() {
        return landDTOList;
    }

    public void setLandDTOList(List<LandDTO> landDTOList) {
        this.landDTOList = landDTOList;
    }

    public String getLandVonMeldeanschriftName() {
        return landVonMeldeanschriftName;
    }

    public void setLandVonMeldeanschriftName(String landVonMeldeanschriftName) {
        this.landVonMeldeanschriftName = landVonMeldeanschriftName;
    }

    public String getLandVonPostanschriftName() {
        return landVonPostanschriftName;
    }

    public void setLandVonPostanschriftName(String landVonPostanschriftName) {
        this.landVonPostanschriftName = landVonPostanschriftName;
    }

    public String getBundeslandVonMeldeanschrift() {
        return bundeslandVonMeldeanschrift;
    }

    public void setBundeslandVonMeldeanschrift(String bundeslandVonMeldeanschrift) {
        this.bundeslandVonMeldeanschrift = bundeslandVonMeldeanschrift;
    }

    public List<BundeslandDTO> getBundeslandDTOList() {
        return bundeslandDTOList;
    }

    public void setBundeslandDTOList(List<BundeslandDTO> bundeslandDTOList) {
        this.bundeslandDTOList = bundeslandDTOList;
    }

    public List<OrtDTO> getOrtDTOList() {
        return ortDTOList;
    }

    public void setOrtDTOList(List<OrtDTO> ortDTOList) {
        this.ortDTOList = ortDTOList;
    }

    public String getBundeslandVonPostanschrift() {
        return bundeslandVonPostanschrift;
    }

    public void setBundeslandVonPostanschrift(String bundeslandVonPostanschrift) {
        this.bundeslandVonPostanschrift = bundeslandVonPostanschrift;
    }

    public List<BundeslandDTO> getBundeslandDTOListPostanschrift() {
        return bundeslandDTOListPostanschrift;
    }

    public void setBundeslandDTOListPostanschrift(List<BundeslandDTO> bundeslandDTOListPostanschrift) {
        this.bundeslandDTOListPostanschrift = bundeslandDTOListPostanschrift;
    }

    public List<OrtDTO> getOrtDTOListPostanschrift() {
        return ortDTOListPostanschrift;
    }

    public void setOrtDTOListPostanschrift(List<OrtDTO> ortDTOListPostanschrift) {
        this.ortDTOListPostanschrift = ortDTOListPostanschrift;
    }

    public List<LandDTO> getLandDTOListPostanschrift() {
        return landDTOListPostanschrift;
    }

    public void setLandDTOListPostanschrift(List<LandDTO> landDTOListPostanschrift) {
        this.landDTOListPostanschrift = landDTOListPostanschrift;
    }

    public Boolean getPostanschriftAktiv() {
        return postanschriftAktiv;
    }

    public void setPostanschriftAktiv(Boolean postanschriftAktiv) {
        this.postanschriftAktiv = postanschriftAktiv;
    }
}
