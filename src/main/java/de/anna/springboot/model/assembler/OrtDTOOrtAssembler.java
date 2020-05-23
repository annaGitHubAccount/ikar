package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.OrtDTO;
import de.anna.springboot.model.entity.Ort;

public final class OrtDTOOrtAssembler {

    public OrtDTOOrtAssembler() {
    }

    public static OrtDTO convertOrtToOrtTDO(Ort ort){

        OrtDTO ortDTO = new OrtDTO();
        ortDTO.setName(ort.getName());

        return ortDTO;
    }
}
