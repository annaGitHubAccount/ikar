package de.anna.springboot.model.enums;

import java.util.Arrays;

public enum AdresseArt {

    MELDEANSCHRIFT("MA", "Meldeanschrift"),
    POSTANSCHRIFT("PA", "Postanschrift");

    private String kode;
    private String text;

    AdresseArt(String kode, String text) {
        this.kode = kode;
        this.text = text;
    }



    public static AdresseArt convertToAdresseArtByKode(String adresseArtByKode){

        AdresseArt[] adresseArts = values();

        return Arrays.stream(adresseArts)
                .filter(adresseArt -> adresseArt.getKode().equals(adresseArtByKode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Es gibt solchen AdresseArt by Kode nicht !!!"));
    }



    public String getKode() {
        return kode;
    }

    public String getText() {
        return text;
    }
}
