package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import java.util.ArrayList;
import java.util.List;

public final class KundeKundeDTOAssembler {

    private KundeKundeDTOAssembler() {
    }

    public static KundeDTO mapKundeToKundeDTO(Kunde kunde) {

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kunde.getId());
        kundeDTO.setSteuerId(kunde.getSteuerId());
        kundeDTO.setName(kunde.getName());
        kundeDTO.setNachname(kunde.getNachname());
        kundeDTO.setBirthDate(kunde.getBirthDate());
        kundeDTO.setKundeArt(kunde.getKundeArt());

        List<AdresseDTO> adresseDTOList = new ArrayList<>();
        List<Adresse> adresseList = kunde.getAdresseList();

        for (Adresse adresse : adresseList) {
            AdresseDTO adresseDTO = AdresseAdresseDTOAssembler.mapAdresseToAdresseDTO(adresse, kundeDTO);
            adresseDTOList.add(adresseDTO);
        }
        kundeDTO.setAdresseList(adresseDTOList);


        List<ProduktDTO> produktDTOList = new ArrayList<>();
        List<Produkt> produktList = kunde.getProduktList();

        for(Produkt produkt :produktList){
            ProduktDTO produktDTO = ProduktProduktDTOAssembler.mapProduktToProduktDTO(produkt, kundeDTO);
            produktDTOList.add(produktDTO);
        }
        kundeDTO.setProduktDTOList(produktDTOList);

        return kundeDTO;
    }


    public static Kunde mapKundeDTOToKunde(KundeDTO kundeDTO, Kunde kunde) {

        kunde.setId(kundeDTO.getId());
        kunde.setSteuerId(kundeDTO.getSteuerId());
        kunde.setName(kundeDTO.getName());
        kunde.setNachname(kundeDTO.getNachname());
        kunde.setBirthDate(kundeDTO.getBirthDate());
        kunde.setKundeArt(kundeDTO.getKundeArt());

        List<Adresse> adresseList = new ArrayList<>();
        List<AdresseDTO> adresseDTOList = kundeDTO.getAdresseList();

        for (AdresseDTO adresseDTO : adresseDTOList) {
            Adresse adresse = AdresseAdresseDTOAssembler.mapAdresseDTOToAdresse(adresseDTO, kunde);
            adresseList.add(adresse);
        }
        kunde.setAdresseList(adresseList);

        List<Produkt> produktList = new ArrayList<>();
        List<ProduktDTO> produktDTOList = kundeDTO.getProduktDTOList();

        for (ProduktDTO produktDTO : produktDTOList){
            Produkt produkt = ProduktProduktDTOAssembler.mapProduktDTOToProdukt(produktDTO, kunde);
            produktList.add(produkt);
        }
        kunde.setProduktList(produktList);

        return kunde;
    }
}
