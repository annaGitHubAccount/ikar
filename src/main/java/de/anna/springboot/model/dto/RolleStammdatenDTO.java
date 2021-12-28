package de.anna.springboot.model.dto;

import java.util.Objects;

public class RolleStammdatenDTO {

    private Long id;

    private String name;

    public RolleStammdatenDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolleStammdatenDTO)) return false;
        RolleStammdatenDTO that = (RolleStammdatenDTO) o;
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
