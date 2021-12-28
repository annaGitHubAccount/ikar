package de.anna.springboot.model.dto;

import java.util.Objects;

public class LandDTO {

    private String symbol;

    private String name;

    public LandDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandDTO)) return false;
        LandDTO landDTO = (LandDTO) o;
        return symbol.equals(landDTO.symbol) &&
                name.equals(landDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
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
}
