package de.anna.springboot.model.dto;

import java.util.Objects;

public class OrtDTO {

    private String name;

    public OrtDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrtDTO)) return false;
        OrtDTO ortDTO = (OrtDTO) o;
        return name.equals(ortDTO.name);
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
