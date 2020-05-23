package de.anna.springboot.model.dto;

import java.util.Objects;

public class BundeslandDTO {

    private String name;

    public BundeslandDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BundeslandDTO)) return false;
        BundeslandDTO that = (BundeslandDTO) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
