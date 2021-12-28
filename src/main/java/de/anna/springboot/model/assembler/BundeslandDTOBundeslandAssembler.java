package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.BundeslandDTO;
import de.anna.springboot.model.entity.Bundesland;

public final class BundeslandDTOBundeslandAssembler {

    public BundeslandDTOBundeslandAssembler() {
    }

    public static BundeslandDTO convertBundeslandToBundeslandDTO(Bundesland bundesland){

        BundeslandDTO bundeslandDTO = new BundeslandDTO();

        bundeslandDTO.setName(bundesland.getName());

        return bundeslandDTO;
    }
}
