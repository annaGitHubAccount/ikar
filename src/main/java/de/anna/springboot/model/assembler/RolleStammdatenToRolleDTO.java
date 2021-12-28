package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.dto.RolleStammdatenDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class RolleStammdatenToRolleDTO {

    private RolleStammdatenToRolleDTO() {
    }


    public static RolleDTO convertRolleStammdatenDTOTORolleDTO(RolleStammdatenDTO rolleStammdatenDTO) {

        RolleDTO rolleDTO = new RolleDTO();

        rolleDTO.setId(rolleStammdatenDTO.getId());
        rolleDTO.setName(rolleStammdatenDTO.getName());

        return rolleDTO;
    }


    public static List<RolleDTO> convertRolleStammdatenDTOToRolleDTOList(List<RolleStammdatenDTO> rolleStammdatenDTOList) {

        return rolleStammdatenDTOList.stream()
                .map(rolleStammdatenDTO -> RolleStammdatenToRolleDTO.convertRolleStammdatenDTOTORolleDTO(rolleStammdatenDTO))
                .collect(Collectors.toList());
    }
}
