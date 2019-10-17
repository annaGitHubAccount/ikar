package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Rolle;

public final class RolleRolleDTOAssembler {

    private RolleRolleDTOAssembler() {
    }


    public static de.anna.springboot.model.dto.RolleDTO convertRolleToRolleDTO(Rolle rolle, KundeDTO  kundeDTO){

        de.anna.springboot.model.dto.RolleDTO rolleDTO = new de.anna.springboot.model.dto.RolleDTO();

        rolleDTO.setId(rolle.getId());
        rolleDTO.setName(rolle.getName());
        rolleDTO.setKundeDTO(kundeDTO);

        return rolleDTO;
    }

    public static de.anna.springboot.model.dto.RolleDTO convertRolleToRolleDTO(Rolle rolle){

        de.anna.springboot.model.dto.RolleDTO rolleDTO = new de.anna.springboot.model.dto.RolleDTO();

        rolleDTO.setId(rolle.getId());
        rolleDTO.setName(rolle.getName());

        return rolleDTO;
    }


    public static Rolle convertRolleDTOToRolle(de.anna.springboot.model.dto.RolleDTO rolleDTO, Kunde kunde){

        Rolle rolle = new Rolle();

        rolle.setId(rolleDTO.getId());
        rolle.setName(rolleDTO.getName());
        rolle.setKunde(kunde);

        return rolle;
    }

    public static Rolle convertRolleDTOToRolle(de.anna.springboot.model.dto.RolleDTO rolleDTO){

        Rolle rolle = new Rolle();

        rolle.setId(rolleDTO.getId());
        rolle.setName(rolleDTO.getName());

        return rolle;
    }
}
