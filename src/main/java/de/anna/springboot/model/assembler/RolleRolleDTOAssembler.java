package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Rolle;

import java.util.List;

public final class RolleRolleDTOAssembler {

    private RolleRolleDTOAssembler() {
    }


    public static RolleDTO convertRolleToRolleDTO(Rolle rolle, KundeDTO  kundeDTO){

        RolleDTO rolleDTO = new RolleDTO();

        rolleDTO.setId(rolle.getId());
        rolleDTO.setName(rolle.getName());
        rolleDTO.setKundeDTO(kundeDTO);

        return rolleDTO;
    }

    public static RolleDTO convertRolleToRolleDTO(Rolle rolle){

        RolleDTO rolleDTO = new RolleDTO();

        rolleDTO.setId(rolle.getId());
        rolleDTO.setName(rolle.getName());

        return rolleDTO;
    }


    public static Rolle convertRolleDTOToRolle(RolleDTO rolleDTO){

        Rolle rolle = new Rolle();

        rolle.setId(rolleDTO.getId());
        rolle.setName(rolleDTO.getName());

        return rolle;
    }
}
