package de.anna.springboot.model.form;

import javax.validation.constraints.Pattern;
import java.util.LinkedHashMap;
import java.util.Map;

public class KundeSucheForm {

    @Pattern(regexp = "(^$)|(^[0-9]{3,9}$)", message = "{steuerId.mussNummerSein}")
    private String steuerId;

    private String kundeNummer;

    private String nachname;

    private Map<String, String> kundeArtMap = new LinkedHashMap<>();

    private String kundeArt;

    private String geburtsdatumAB;

    private String geburtsdatumBIS;


    public String getSteuerId() {
        return steuerId;
    }

    public void setSteuerId(String steuerId) {
        this.steuerId = steuerId;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
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

    public String getGeburtsdatumAB() {
        return geburtsdatumAB;
    }

    public void setGeburtsdatumAB(String geburtsdatumAB) {
        this.geburtsdatumAB = geburtsdatumAB;
    }

    public String getGeburtsdatumBIS() {
        return geburtsdatumBIS;
    }

    public void setGeburtsdatumBIS(String geburtsdatumBIS) {
        this.geburtsdatumBIS = geburtsdatumBIS;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public void setKundeNummer(String kundeNummer) {
        this.kundeNummer = kundeNummer;
    }
}
