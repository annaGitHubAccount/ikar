package de.anna.springboot.model.form;

import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;

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

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    @Size(min = 9, max = 9, message = "{steuerId.muss9DiditsHaben}")
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

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String ortVonMeldeanschrift;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String strasseVonMeldeanschrift;

    @NotNull(message = "{feld.isErfordelich}")
    @NotEmpty(message = "{feld.isErfordelich}")
    private String hausNrVonMeldeanschrift;

    private String landVonPostanschrift;
    private String ortVonPostanschrift;
    private String strasseVonPostanschrift;
    private String hausNrVonPostanschrift;

    private List<ProduktDTO> produktStammdatenList = new ArrayList<>();
    private List<String> produktStammdatenGewaehlteList = new ArrayList<>();

    private List<ProduktDTO> produktList = new ArrayList<>();
    private List<String> produktGewaehlteList = new ArrayList<>();


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

    public List<ProduktDTO> getProduktStammdatenList() {
        return produktStammdatenList;
    }

    public void setProduktStammdatenList(List<ProduktDTO> produktStammdatenList) {
        this.produktStammdatenList = produktStammdatenList;
    }

    public List<String> getProduktStammdatenGewaehlteList() {
        return produktStammdatenGewaehlteList;
    }

    public void setProduktStammdatenGewaehlteList(List<String> produktStammdatenGewaehlteList) {
        this.produktStammdatenGewaehlteList = produktStammdatenGewaehlteList;
    }

    public List<ProduktDTO> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<ProduktDTO> produktList) {
        this.produktList = produktList;
    }

    public List<String> getProduktGewaehlteList() {
        return produktGewaehlteList;
    }

    public void setProduktGewaehlteList(List<String> produktGewaehlteList) {
        this.produktGewaehlteList = produktGewaehlteList;
    }

}
