package de.anna.springboot.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

        return Arrays.stream(produktArts)
                .filter(produktArt -> produktArt.getKode().equals(produktArtAlsString))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Solchen Kode von ProduktArt gibt es nicht !!!"));
    }

    public static String convertProduktArtToString(ProduktArt produktArt) {

        return produktArt.getKode();

    }

    public static Map<String, String> convertProduktArtEnumToMap() {

        ProduktArt[] produktArts = values();

        return Arrays.stream(produktArts)
                .collect(Collectors.toMap(ProduktArt::getKode, ProduktArt::getText));
    }


    public String getKode() {
        return kode;
    }

    public String getText() {
        return text;
    }
}
