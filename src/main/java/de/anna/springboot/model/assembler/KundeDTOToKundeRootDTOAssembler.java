package de.anna.springboot.model.assembler;

import de.anna.springboot.controller.helper.RolleDTOHelper;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.dto.xml.KundeRootDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import java.util.List;

public class KundeDTOToKundeRootDTOAssembler {

    public static KundeRootDTO convertKundeZeileListDTOToKundeRootDTO(List<KundeZeileDTO> kundenList) {

        KundeRootDTO kundeRootDTO = new KundeRootDTO();

        kundeRootDTO.setKundeZeileDTOList(kundenList);

        return kundeRootDTO;
    }


    public static List<KundeZeileDTO> convertKundeDTOListToKundeZeileDTOList(List<KundeDTO> kundenList) {

       return kundenList.stream()
               .map(KundeDTOToKundeRootDTOAssembler::convertKundeDTOToKundeZeileDTO)
               .toList();
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
