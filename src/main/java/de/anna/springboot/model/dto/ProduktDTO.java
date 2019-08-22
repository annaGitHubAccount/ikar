package de.anna.springboot.model.dto;

import de.anna.springboot.model.enums.ProduktArt;
import java.math.BigDecimal;

public class ProduktDTO {

    private Long id;

    private String symbol;

    private String name;

    private BigDecimal preis;

    private boolean aktiv;

    private ProduktArt produktArt;

    private KundeDTO kundeDTO;


    public ProduktDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public ProduktArt getProduktArt() {
        return produktArt;
    }

    public void setProduktArt(ProduktArt produktArt) {
        this.produktArt = produktArt;
    }

    public KundeDTO getKundeDTO() {
        return kundeDTO;
    }

    public void setKundeDTO(KundeDTO kundeDTO) {
        this.kundeDTO = kundeDTO;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
