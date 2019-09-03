package de.anna.springboot.model.form;

import javax.validation.constraints.Size;
import java.util.LinkedHashMap;
import java.util.Map;

public class KundeSucheForm {

    //@Size(min = 3, max = 9, message = "{steuerId.mussMind3DigitsHaben}")
    private String steuerId;

    private String nachname;

    private Map<String, String> kundeArtMap = new LinkedHashMap<>();

    private String kundeArt;


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
}
