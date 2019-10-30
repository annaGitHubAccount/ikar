package de.anna.springboot.model.assembler;

import de.anna.springboot.controller.helper.RolleDTOHelper;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.dto.xml.KundeRootDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;

import java.util.ArrayList;
import java.util.List;

public class KundeDTOToKundeRootDTOAssembler {

    public static KundeRootDTO convertKundeZeileListDTOToKundeRootDTO(List<KundeZeileDTO> kundenList) {

        KundeRootDTO kundeRootDTO = new KundeRootDTO();

        kundeRootDTO.setKundeZeileDTOList(kundenList);

        return kundeRootDTO;
    }

    //TODO
    public static List<KundeZeileDTO> convertKundeDTOListToKundeZeileDTOList(List<KundeDTO> kundenList) {

        List<KundeZeileDTO> kundeZeileDTOList = new ArrayList<>();

        for (KundeDTO kundeDTO : kundenList) {
            KundeZeileDTO kundeZeileDTO = convertKundeDTOToKundeZeileDTO(kundeDTO);
            kundeZeileDTOList.add(kundeZeileDTO);
        }

        return kundeZeileDTOList;
    }

    private static KundeZeileDTO convertKundeDTOToKundeZeileDTO(KundeDTO kundeDTO) {

        KundeZeileDTO kundeZeileDTO = new KundeZeileDTO();

        kundeZeileDTO.setId(kundeDTO.getId());
        kundeZeileDTO.setSteuerId(kundeDTO.getSteuerId());
        kundeZeileDTO.setName(kundeDTO.getName());
        kundeZeileDTO.setNachname(kundeDTO.getNachname());
        kundeZeileDTO.setBirthDate(kundeDTO.getBirthDate());
        kundeZeileDTO.setKundeArt(kundeDTO.getKundeArt());
        kundeZeileDTO.setKundeNummer(kundeDTO.getKundeNummer());

        List<RolleDTO> rolleDTOList = kundeDTO.getRolleDTOList();
        String rollenAsAtring = RolleDTOHelper.convertRolleDTOListToString(rolleDTOList);
        kundeZeileDTO.setRolle(rollenAsAtring);

        return kundeZeileDTO;
    }


}
