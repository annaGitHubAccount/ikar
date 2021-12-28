package de.anna.springboot.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Land {

    @Id
    private Long id;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "land")
    private List<Bundesland> bundeslandList;


    public Land() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Land)) return false;
        Land land = (Land) o;
        return getId().equals(land.getId()) &&
                getSymbol().equals(land.getSymbol()) &&
                getName().equals(land.getName());
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bundesland> getBundeslandList() {
        return bundeslandList;
    }

    public void setBundeslandList(List<Bundesland> bundeslandList) {
        this.bundeslandList = bundeslandList;
    }
}
