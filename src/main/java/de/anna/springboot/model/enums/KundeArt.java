package de.anna.springboot.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum KundeArt {

    BRONZE("BR", "Bronze"),
    SILBER("SB", "Silber"),
    GOLD("GD", "Gold");

    private String kode;
    private String text;


    KundeArt(String kode, String text) {
        this.kode = kode;
        this.text = text;
    }


    public static Map<String, String> convertKundeArtEnumToTextTextMap() {

        Map<String, String> kundeArtMap = new HashMap<>();
        KundeArt[] kundeArtEnumArray = values();

        for (KundeArt kundeArt : kundeArtEnumArray) {
            kundeArtMap.put(kundeArt.getText(), kundeArt.getText());
        }

        return kundeArtMap;
    }

    public static Map<String, String> convertKundeArtEnumToKodeTextMap() {

        Map<String, String> kundeArtMap = new HashMap<>();
        KundeArt[] kundeArtEnumArray = values();

        for (KundeArt kundeArt : kundeArtEnumArray) {
            kundeArtMap.put(kundeArt.getKode(), kundeArt.getText());
        }

        return kundeArtMap;
    }

    public static KundeArt convertToKundeArtByCode(String kundeArtByKode) {

        KundeArt[] kundeArtsArray = values();

        for(KundeArt kundeArt : kundeArtsArray){
            if(kundeArt.getKode().equals(kundeArtByKode)){
                return kundeArt;
            }
        }

        // return null; // nieladnie zwracac null, wiec lepiej rzucic wyjatek
        throw new RuntimeException("Es gibt solchen KundenArt by Kode nicht: " + kundeArtByKode + " !!!");

    }

    public static KundeArt convertToKundeArtByText(String kundeArtByText) {

        KundeArt[] kundeArtsArray = values();

        for(KundeArt kundeArt : kundeArtsArray){
            if(kundeArt.getText().equals(kundeArtByText)){
                return kundeArt;
            }
        }

        throw new RuntimeException("Es gibt solchen KundenArt by Text nicht !!!");

    }

    public static String convertKundeArtKodeToText(String kundeArtKode) {

        KundeArt[] kundeArtsArray = values();

        for (KundeArt kundeArt : kundeArtsArray) {
            if (kundeArt.getKode().equals(kundeArtKode)) {
                return kundeArt.getText();
            }
        }

        throw new RuntimeException("Es gibt solchen Kode nicht !!!");
    }


    public String getKode() {
        return kode;
    }

    public String getText() {
        return text;
    }

}
