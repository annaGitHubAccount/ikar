package de.anna.springboot.model.dto;

public class KundeAnzahlLandDTO {

    private Long anzahlVonKunden;

    private String land;


    public KundeAnzahlLandDTO(String land, Long anzahlVonKunden) {
        this.anzahlVonKunden = anzahlVonKunden;
        this.land = land;
    }

    public Long getAnzahlVonKunden() {
        return anzahlVonKunden;
    }

    public void setAnzahlVonKunden(Long anzahlVonKunden) {
        this.anzahlVonKunden = anzahlVonKunden;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
