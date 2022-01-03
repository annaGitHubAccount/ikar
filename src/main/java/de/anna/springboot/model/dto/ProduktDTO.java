package de.anna.springboot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.anna.springboot.model.enums.ProduktArt;

import java.math.BigDecimal;
import java.util.Objects;

public class ProduktDTO {

    private Long id;

    private String symbol;

    private String name;

    private BigDecimal preis;

    private boolean aktiv;

    private ProduktArt produktArt;

    @JsonIgnore
    private KundeDTO kundeDTO;


    public ProduktDTO() {
    }

    public ProduktDTO(String symbol, String name, BigDecimal preis, boolean aktiv) {
        this.symbol = symbol;
        this.name = name;
        this.preis = preis;
        this.aktiv = aktiv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktDTO)) return false;
        ProduktDTO that = (ProduktDTO) o;
        return getSymbol().equals(that.getSymbol());
    }

    @Override
    public String toString() {

        return "id: " + this.id +
                ", symbol: " + this.symbol +
                ", name: " + this.name +
                ", preis: " + this.preis +
                ", isAktiv: " + this.aktiv +
                ", produktArt: " + this.produktArt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol());
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
