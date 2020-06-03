package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class ProduktStammdatenDTOProduktDTOAssembler {


    private ProduktStammdatenDTOProduktDTOAssembler() {
    }


    private static ProduktDTO convertProduktStammdatenDTOToProduktDTO(ProduktStammdatenDTO produktStammdatenDTO){

        ProduktDTO produktDTO = new ProduktDTO();

        produktDTO.setId(produktStammdatenDTO.getId());
        produktDTO.setSymbol(produktStammdatenDTO.getSymbol());
        produktDTO.setName(produktStammdatenDTO.getName());
        produktDTO.setPreis(produktStammdatenDTO.getPreis());
        produktDTO.setProduktArt(produktStammdatenDTO.getProduktArt());
        produktDTO.setAktiv(produktStammdatenDTO.isAktiv());

        return produktDTO;

    }

    public static List<ProduktDTO> convertProduktStammdatenDTOToProduktDTO(List<ProduktStammdatenDTO> produktStammdatenDTOList){

        return produktStammdatenDTOList.stream()
                .map(produktStammdatenDTO -> {
                    ProduktDTO produktDTO = ProduktStammdatenDTOProduktDTOAssembler.convertProduktStammdatenDTOToProduktDTO(produktStammdatenDTO);
                    return produktDTO;
                })
                .collect(Collectors.toList());
    }


    public static ProduktStammdatenDTO convertProduktDTOToProduktStammdatenDTO(ProduktDTO produktDTO){

        ProduktStammdatenDTO produktStammdatenDTO = new ProduktStammdatenDTO();

        produktStammdatenDTO.setId(produktDTO.getId());
        produktStammdatenDTO.setSymbol(produktDTO.getSymbol());
        produktStammdatenDTO.setName(produktDTO.getName());
        produktStammdatenDTO.setPreis(produktDTO.getPreis());
        produktStammdatenDTO.setProduktArt(produktDTO.getProduktArt());
        produktStammdatenDTO.setAktiv(produktDTO.isAktiv());

        return produktStammdatenDTO;
    }
}
