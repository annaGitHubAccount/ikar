package de.anna.springboot.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RolleStammdaten {

    @Id
    @GeneratedValue(generator = "RolleStammdatenGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RolleStammdatenGenerator", sequenceName = "rolle_stammdaten_id_seq", allocationSize = 1)
    private Long id;

    private String name;


    public RolleStammdaten() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolleStammdaten)) return false;
        RolleStammdaten that = (RolleStammdaten) o;
        return getName().equals(that.getName());
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
}
