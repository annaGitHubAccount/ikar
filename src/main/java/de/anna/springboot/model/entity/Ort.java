package de.anna.springboot.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ort {

    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="BUNDESLAND_ID")
    private Bundesland bundesland;

    public Ort() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ort)) return false;
        Ort ort = (Ort) o;
        return name.equals(ort.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }
}
