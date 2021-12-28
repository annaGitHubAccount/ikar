package de.anna.springboot.model.assembler;


import de.anna.springboot.controller.helper.RolleDTOHelper;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Rolle;

import java.util.List;

public final class KundeKundeZeileDTOAssembler {

    private KundeKundeZeileDTOAssembler() {
    }

    public static KundeZeileDTO mapKundeToKundeZeileDTO(Kunde kunde) {

        KundeZeileDTO kundeZeileDTO = new KundeZeileDTO();

        kundeZeileDTO.setId(kunde.getId());
        kundeZeileDTO.setName(kunde.getName());
        kundeZeileDTO.setNachname(kunde.getNachname());
        kundeZeileDTO.setSteuerId(kunde.getSteuerId());
        kundeZeileDTO.setBirthDate(kunde.getBirthDate());
        kundeZeileDTO.setKundeArt(kunde.getKundeArt());
        kundeZeileDTO.setKundeNummer(kunde.getKundeNummer());

        List<Rolle> rolleList = kunde.getRolleList();
        String stringVonRollen = RolleDTOHelper.convertRolleListToString(rolleList);
        kundeZeileDTO.setRolle(stringVonRollen);

        return kundeZeileDTO;
    }
}
