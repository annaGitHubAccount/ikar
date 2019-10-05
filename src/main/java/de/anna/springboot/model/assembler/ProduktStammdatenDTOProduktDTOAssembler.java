package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;

import java.util.ArrayList;
import java.util.List;

public final class ProduktStammdatenDTOProduktDTOAssembler {


    private ProduktStammdatenDTOProduktDTOAssembler() {
    }


    public static ProduktDTO convertProduktStammdatenDTOToProduktDTO(ProduktStammdatenDTO produktStammdatenDTO){

        ProduktDTO produktDTO = new ProduktDTO();

        produktDTO.setSymbol(produktStammdatenDTO.getSymbol());
        produktDTO.setName(produktStammdatenDTO.getName());
        produktDTO.setPreis(produktStammdatenDTO.getPreis());
        produktDTO.setProduktArt(produktStammdatenDTO.getProduktArt());
        produktDTO.setAktiv(produktStammdatenDTO.isAktiv());

        return produktDTO;

    }

    public static List<ProduktDTO> convertProduktStammdatenDTOToProduktDTO(List<ProduktStammdatenDTO> produktStammdatenDTOList){

        List<ProduktDTO> produktStammdatenDTOToProduktDTOList = new ArrayList<>();

        for(ProduktStammdatenDTO produktStammdatenDTO : produktStammdatenDTOList){
            ProduktDTO produktDTO = ProduktStammdatenDTOProduktDTOAssembler.convertProduktStammdatenDTOToProduktDTO(produktStammdatenDTO);
            produktStammdatenDTOToProduktDTOList.add(produktDTO);
        }

        return produktStammdatenDTOToProduktDTOList;
    }


    public static ProduktStammdatenDTO convertProduktDTOToProduktStammdatenDTO(ProduktDTO produktDTO){

        ProduktStammdatenDTO produktStammdatenDTO = new ProduktStammdatenDTO();

        produktStammdatenDTO.setSymbol(produktDTO.getSymbol());
        produktStammdatenDTO.setName(produktDTO.getName());
        produktStammdatenDTO.setPreis(produktDTO.getPreis());
        produktStammdatenDTO.setProduktArt(produktDTO.getProduktArt());
        produktStammdatenDTO.setAktiv(produktDTO.isAktiv());

        return produktStammdatenDTO;
    }
}
