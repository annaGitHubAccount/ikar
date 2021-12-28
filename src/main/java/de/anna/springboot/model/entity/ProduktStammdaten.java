package de.anna.springboot.model.entity;

import de.anna.springboot.model.enums.ProduktArt;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUKT_STAMMDATEN")
public class ProduktStammdaten {


    @Id
    @GeneratedValue(generator = "ProduktStammdatenGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProduktStammdatenGenerator", sequenceName = "produkt_stammdaten_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "NAME")
    private String name;

    // Precision is the total number of digits. Scale is the number of digits after the decimal point.
    @Column(name = "PREIS", precision=10, scale=2)
    private BigDecimal preis;

    @Column(name = "IS_AKTIV")
    private boolean aktiv;

    @Column(name = "PRODUKT_ART")
    private ProduktArt produktArt;


    public ProduktStammdaten() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktStammdaten)) return false;
        ProduktStammdaten that = (ProduktStammdaten) o;
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
