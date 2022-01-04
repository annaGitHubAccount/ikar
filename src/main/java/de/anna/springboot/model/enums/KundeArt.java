package de.anna.springboot.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

        KundeArt[] kundeArtEnumArray = values();

        return Arrays.stream(kundeArtEnumArray)
                .collect(Collectors.toMap(KundeArt::getText, KundeArt::getText));
    }

    public static Map<String, String> convertKundeArtEnumToKodeTextMap() {

        KundeArt[] kundeArtEnumArray = values();

        return Arrays.stream(kundeArtEnumArray)
                .collect(Collectors.toMap(KundeArt::getKode, KundeArt::getText));
    }

    public static KundeArt convertToKundeArtByCode(String kundeArtByKode) {

        KundeArt[] kundeArtsArray = values();

        return Arrays.stream(kundeArtsArray)
                .filter(kundeArt -> kundeArt.getKode().equals(kundeArtByKode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Es gibt solchen KundenArt by Kode nicht: " + kundeArtByKode + " !!!"));
    }

    public static KundeArt convertToKundeArtByText(String kundeArtByText) {

        KundeArt[] kundeArtsArray = values();

        return Arrays.stream(kundeArtsArray)
                .filter(kundeArt -> kundeArt.getText().equals(kundeArtByText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Es gibt solchen KundenArt by Text nicht !!!"));
    }

    public static String convertKundeArtKodeToText(String kundeArtKode) {

        KundeArt[] kundeArtsArray = values();

        return Arrays.stream(kundeArtsArray)
                .filter(kundeArt -> kundeArt.getKode().equals(kundeArtKode))
                .findFirst()
                .map(KundeArt::getText)
                .orElseThrow(() -> new RuntimeException("Es gibt solchen Kode nicht !!!"));
    }


    public String getKode() {
        return kode;
    }

    public String getText() {
        return text;
    }

}
