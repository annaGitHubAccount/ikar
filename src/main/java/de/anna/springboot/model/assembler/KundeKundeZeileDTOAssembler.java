package de.anna.springboot.model.assembler;


import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.entity.Kunde;

public final class KundeKundeZeileDTOAssembler {

    private KundeKundeZeileDTOAssembler() {
    }

    public static KundeZeileDTO mapKundeToKundeZeileDTO(Kunde kunde){

        KundeZeileDTO kundeZeileDTO = new KundeZeileDTO();

        kundeZeileDTO.setId(kunde.getId());
        kundeZeileDTO.setName(kunde.getName());
        kundeZeileDTO.setNachname(kunde.getNachname());
        kundeZeileDTO.setSteuerId(kunde.getSteuerId());
        kundeZeileDTO.setBirthDate(kunde.getBirthDate());
        kundeZeileDTO.setKundeArt(kunde.getKundeArt());
        kundeZeileDTO.setKundeNummer(kunde.getKundeNummer());

        return kundeZeileDTO;
    }
}
