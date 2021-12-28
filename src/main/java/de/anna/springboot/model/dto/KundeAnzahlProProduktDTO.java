package de.anna.springboot.model.dto;

public class KundeAnzahlProProduktDTO {

    private Long anzahlVonKunden;

    private String produktName;


    public KundeAnzahlProProduktDTO(String produktName, Long anzahlVonKunden) {
        this.anzahlVonKunden = anzahlVonKunden;
        this.produktName = produktName;
    }

    public Long getAnzahlVonKunden() {
        return anzahlVonKunden;
    }

    public void setAnzahlVonKunden(Long anzahlVonKunden) {
        this.anzahlVonKunden = anzahlVonKunden;
    }

    public String getProduktName() {
        return produktName;
    }

    public void setProduktName(String produktName) {
        this.produktName = produktName;
    }
}
