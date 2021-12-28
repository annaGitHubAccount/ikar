package de.anna.springboot.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rolle {

    @Id
    @GeneratedValue(generator = "RolleGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RolleGenerator", sequenceName = "rolle_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="KUNDE_ID")
    private Kunde kunde;


    public Rolle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rolle)) return false;
        Rolle rolle = (Rolle) o;
        return getName().equals(rolle.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
