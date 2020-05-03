package de.anna.springboot.model.form;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProduktStammdatenSucheForm {

    private String name;

    // liczba lub liczba z max. 2 cyframi po przecinku:
    @Digits(integer = 10, fraction = 2, message = "{preis.hatKeinErforderlichesFormat}")
    private BigDecimal preisAB;

    @Digits(integer = 10, fraction = 2, message = "{preis.hatKeinErforderlichesFormat}")
    private BigDecimal preisBIS;

    private String aktiv;

    private Map<String, String> isAktivMap = new HashMap<>();

    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPreisAB() {
        return preisAB;
    }

    public void setPreisAB(BigDecimal preisAB) {
        this.preisAB = preisAB;
    }

    public BigDecimal getPreisBIS() {
        return preisBIS;
    }

    public void setPreisBIS(BigDecimal preisBIS) {
        this.preisBIS = preisBIS;
    }

    public String getAktiv() {
        return aktiv;
    }

    public void setAktiv(String aktiv) {
        this.aktiv = aktiv;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Map<String, String> getIsAktivMap() {
        return isAktivMap;
    }

    public void setIsAktivMap(Map<String, String> isAktivMap) {
        this.isAktivMap = isAktivMap;
    }
}
