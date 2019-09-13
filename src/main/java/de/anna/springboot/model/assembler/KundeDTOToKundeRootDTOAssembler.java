package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeRootDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;

import java.util.ArrayList;
import java.util.List;

public class KundeDTOToKundeRootDTOAssembler {

    public static KundeRootDTO convertKundeListDTOToKundeRootDTO(List<KundeDTO> kundenList) {

        KundeRootDTO kundeRootDTO = new KundeRootDTO();

        List<KundeZeileDTO> kundeZeileDTOList = convertKundeDTOListToKundeZeileDTOList(kundenList);

        kundeRootDTO.setKundeZeileDTOList(kundeZeileDTOList);

        return kundeRootDTO;
    }

    private static List<KundeZeileDTO> convertKundeDTOListToKundeZeileDTOList(List<KundeDTO> kundenList) {

        List<KundeZeileDTO> kundeZeileDTOList = new ArrayList<>();

        for (KundeDTO kundeDTO : kundenList) {
            KundeZeileDTO kundeZeileDTO = convertKundeDTOToKundeZeileDTO(kundeDTO);
            kundeZeileDTOList.add(kundeZeileDTO);
        }

        return kundeZeileDTOList;
    }

    private static KundeZeileDTO convertKundeDTOToKundeZeileDTO(KundeDTO kundeDTO) {

        KundeZeileDTO kundeZeileDTO = new KundeZeileDTO();

        kundeZeileDTO.setSteuerId(kundeDTO.getSteuerId());
        kundeZeileDTO.setName(kundeDTO.getName());
        kundeZeileDTO.setNachname(kundeDTO.getNachname());
        kundeZeileDTO.setBirthDate(kundeDTO.getBirthDate());
        kundeZeileDTO.setKundeArt(kundeDTO.getKundeArt());

        return kundeZeileDTO;
    }


}
