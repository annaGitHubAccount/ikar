package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;

public final class AdresseAdresseDTOAssembler {

    private AdresseAdresseDTOAssembler() {
    }

    public static AdresseDTO mapAdresseToAdresseDTO(Adresse adresse, KundeDTO  kundeDTO){

        AdresseDTO adresseDTO = new AdresseDTO();

        adresseDTO.setLand(adresse.getLand());
        adresseDTO.setOrt(adresse.getOrt());
        adresseDTO.setBundesland(adresse.getBundesland());
        adresseDTO.setPostleitzahl(adresse.getPostleitzahl());
        adresseDTO.setAdresseArt(adresse.getAdresseArt());
        adresseDTO.setStrasse(adresse.getStrasse());
        adresseDTO.setHausNr(adresse.getHausNr());
        adresseDTO.setId(adresse.getId());
        adresseDTO.setKundeDTO(kundeDTO);

        return adresseDTO;
    }

    public static Adresse mapAdresseDTOToAdresse(AdresseDTO adresseDTO, Kunde kunde){

        Adresse adresse = new Adresse();

        adresse.setLand(adresseDTO.getLand());
        adresse.setBundesland(adresseDTO.getBundesland());
        adresse.setOrt(adresseDTO.getOrt());
        adresse.setPostleitzahl(adresseDTO.getPostleitzahl());
        adresse.setAdresseArt(adresseDTO.getAdresseArt());
        adresse.setStrasse(adresseDTO.getStrasse());
        adresse.setHausNr(adresseDTO.getHausNr());
        adresse.setId(adresseDTO.getId());
        adresse.setKunde(kunde);

        return adresse;
    }
}
