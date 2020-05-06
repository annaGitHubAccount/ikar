package de.anna.springboot.model.entity;

import de.anna.springboot.model.enums.ProduktArt;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Produkt {

    @Id
    @GeneratedValue(generator = "ProduktGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProduktGenerator", sequenceName = "produkt_id_seq", allocationSize = 1)
    private Long id;

    private String symbol;

    private String name;

    // Precision is the total number of digits. Scale is the number of digits after the decimal point.
    @Column(precision=10, scale=2)
    private BigDecimal preis;

    @Column(name = "IS_AKTIV")
    private boolean aktiv;

    @Column(name = "PRODUKT_ART")
    private ProduktArt produktArt;

    @ManyToOne
    @JoinColumn(name="KUNDE_ID")
    private Kunde kunde;

    public Produkt() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produkt)) return false;
        Produkt produkt = (Produkt) o;
        return getSymbol().equals(produkt.getSymbol());
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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
