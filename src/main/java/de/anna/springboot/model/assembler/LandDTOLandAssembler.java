package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.LandDTO;
import de.anna.springboot.model.entity.Land;

public final class LandDTOLandAssembler {

    public LandDTOLandAssembler() {
    }

    public static LandDTO mapLandToLandDTO(Land land){

        LandDTO landDTO = new LandDTO();

        landDTO.setName(land.getName());
        landDTO.setSymbol(land.getSymbol());

        return landDTO;
    }


}
