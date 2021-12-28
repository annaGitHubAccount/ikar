package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.entity.ProduktStammdaten;

public final class ProduktStammdatenProductStammdatenDTOAssembler {

    private ProduktStammdatenProductStammdatenDTOAssembler() {
    }


    public static ProduktStammdatenDTO mapProduktStammdatenToProduktStammdatenDTO(ProduktStammdaten produktStammdaten) {

        ProduktStammdatenDTO produktStammdatenDTO = new ProduktStammdatenDTO();

        produktStammdatenDTO.setId(produktStammdaten.getId());
        produktStammdatenDTO.setName(produktStammdaten.getName());
        produktStammdatenDTO.setPreis(produktStammdaten.getPreis());
        produktStammdatenDTO.setAktiv(produktStammdaten.isAktiv());
        produktStammdatenDTO.setProduktArt(produktStammdaten.getProduktArt());
        produktStammdatenDTO.setSymbol(produktStammdaten.getSymbol());

        return produktStammdatenDTO;
    }


    public static ProduktStammdaten mapProduktStammdatenDTOToProduktStammdaten(ProduktStammdaten produktStammdaten, ProduktStammdatenDTO produktStammdatenDTO) {

        produktStammdaten.setId(produktStammdatenDTO.getId());
        produktStammdaten.setName(produktStammdatenDTO.getName());
        produktStammdaten.setPreis(produktStammdatenDTO.getPreis());
        produktStammdaten.setAktiv(produktStammdatenDTO.isAktiv());
        produktStammdaten.setProduktArt(produktStammdatenDTO.getProduktArt());
        produktStammdaten.setSymbol(produktStammdatenDTO.getSymbol());

        return produktStammdaten;
    }
}
