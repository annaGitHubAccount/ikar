package de.anna.springboot.model.dto;

import de.anna.springboot.model.enums.ProduktArt;

import java.math.BigDecimal;
import java.util.Objects;

public class ProduktStammdatenDTO {

    private Long id;

    private String symbol;

    private String name;

    private BigDecimal preis;

    private boolean aktiv;

    private ProduktArt produktArt;


    public ProduktStammdatenDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktStammdatenDTO)) return false;
        ProduktStammdatenDTO that = (ProduktStammdatenDTO) o;
        return getSymbol().equals(that.getSymbol());
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
