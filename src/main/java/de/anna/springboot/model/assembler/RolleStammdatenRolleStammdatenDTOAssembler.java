package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.RolleStammdatenDTO;
import de.anna.springboot.model.entity.RolleStammdaten;

public final class RolleStammdatenRolleStammdatenDTOAssembler {

    private RolleStammdatenRolleStammdatenDTOAssembler() {
    }

    public static RolleStammdaten convertRolleStammdatenDTOToRolleStammdaten(RolleStammdatenDTO rolleStammdatenDTO) {

        RolleStammdaten rolleStammdaten = new RolleStammdaten();

        rolleStammdaten.setId(rolleStammdatenDTO.getId());
        rolleStammdaten.setName(rolleStammdatenDTO.getName());

        return rolleStammdaten;
    }


    public static RolleStammdatenDTO convertRolleStammdatenToRolleStammdatenDTO(RolleStammdaten rolleStammdaten) {

        RolleStammdatenDTO rolleStammdatenDTO = new RolleStammdatenDTO();

        rolleStammdatenDTO.setId(rolleStammdaten.getId());
        rolleStammdatenDTO.setName(rolleStammdaten.getName());

        return rolleStammdatenDTO;

    }
}
