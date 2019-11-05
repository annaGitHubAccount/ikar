package de.anna.springboot.model.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProduktStammdatenForm {


    private Long id;

    @Size(min = 1, message = "{feld.isErfordelich}")
    private String name;

    // liczba lub liczba z max. 2 cyframi po przecinku:
    @Digits(integer = 10, fraction = 2, message = "{preis.hatKeinErforderlichesFormat}")
    private BigDecimal preis;

    private boolean aktiv;

    private String produktArt;

    private String symbol;



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

    public String getProduktArt() {
        return produktArt;
    }

    public void setProduktArt(String produktArt) {
        this.produktArt = produktArt;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
