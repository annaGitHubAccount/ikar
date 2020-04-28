package de.anna.springboot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class RolleDTO {

    private Long id;

    private String name;

    @JsonIgnore
    private KundeDTO kundeDTO;

    private Long kundeId;



    public RolleDTO() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolleDTO)) return false;
        RolleDTO rolleDTO = (RolleDTO) o;
        return getName().equals(rolleDTO.getName());
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

    public KundeDTO getKundeDTO() {
        return kundeDTO;
    }

    public void setKundeDTO(KundeDTO kundeDTO) {
        this.kundeDTO = kundeDTO;
    }

    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }
}
