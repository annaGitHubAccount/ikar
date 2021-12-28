package de.anna.springboot.model.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ProduktArt {


    SMALL("S", "Small"),
    MEDIUM("M", "Medium"),
    LARGE("L", "Large");


    private String kode;
    private String text;

    ProduktArt(String kode, String text) {
        this.kode = kode;
        this.text = text;
    }

    public static ProduktArt convertStringToProduktArt(String produktArtAlsString) {

        ProduktArt[] produktArts = values();

        for(ProduktArt produktArt : produktArts){
            if(produktArt.getKode().equals(produktArtAlsString)){
                return produktArt;
            }
        }

        throw new RuntimeException("Solchen Kode von ProduktArt gibt es nicht !!!");
    }

    public static String convertProduktArtToString(ProduktArt produktArt) {

        return produktArt.getKode();

    }

    public static Map<String, String> convertProduktArtEnumToMap() {

        Map<String, String> produktArtMap = new LinkedHashMap<>();
        ProduktArt[] produktArts = values();

        for(ProduktArt produktArt : produktArts){
            produktArtMap.put(produktArt.getKode(), produktArt.getText());
        }

        return produktArtMap;
    }


    public String getKode() {
        return kode;
    }

    public String getText() {
        return text;
    }
}
