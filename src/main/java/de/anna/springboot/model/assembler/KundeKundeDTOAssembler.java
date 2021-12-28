package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.util.MathUtils;

import java.util.List;
import java.util.stream.Collectors;

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
        kundeDTO.setKundeNummer(kunde.getKundeNummer());

        List<AdresseDTO> adresseDTOList = convertAddresseToAdresseDTOList(kunde, kundeDTO);
        kundeDTO.setAdresseList(adresseDTOList);

        List<ProduktDTO> produktDTOList = convertProduktToProduktDTOList(kunde, kundeDTO);
        kundeDTO.setProduktDTOList(produktDTOList);

        List<RolleDTO> rolleListDTO = convertRolleToRolleDTOList(kunde, kundeDTO);
        kundeDTO.setRolleDTOList(rolleListDTO);

        return kundeDTO;
    }

    private static List<RolleDTO> convertRolleToRolleDTOList(Kunde kunde, KundeDTO kundeDTO) {

        List<Rolle> rolleList = kunde.getRolleList();

        return rolleList.stream()
                .map(rolle -> RolleRolleDTOAssembler.convertRolleToRolleDTO(rolle, kundeDTO))
                .collect(Collectors.toList());
    }

    private static List<AdresseDTO> convertAddresseToAdresseDTOList(Kunde kunde, KundeDTO kundeDTO) {

        List<Adresse> adresseList = kunde.getAdresseList();

        return adresseList.stream()
                .map(adresse -> AdresseAdresseDTOAssembler.mapAdresseToAdresseDTO(adresse, kundeDTO))
                .collect(Collectors.toList());
    }

    private static List<ProduktDTO> convertProduktToProduktDTOList(Kunde kunde, KundeDTO kundeDTO) {

        List<Produkt> produktList = kunde.getProduktList();

        return produktList.stream()
                .map(produkt -> ProduktProduktDTOAssembler.mapProduktToProduktDTO(produkt, kundeDTO))
                .collect(Collectors.toList());
    }


    public static Kunde mapKundeDTOToKunde(KundeDTO kundeDTO, Kunde kunde) {

        kunde.setId(kundeDTO.getId());
        kunde.setSteuerId(kundeDTO.getSteuerId());
        kunde.setName(kundeDTO.getName());
        kunde.setNachname(kundeDTO.getNachname());
        kunde.setBirthDate(kundeDTO.getBirthDate());
        kunde.setKundeArt(kundeDTO.getKundeArt());
        kunde.setKundeNummer(kundeDTO.getKundeNummer());

        List<Adresse> adresseList = convertAdresseDTOToAdresseList(kundeDTO, kunde);
        kunde.setAdresseList(adresseList);

        List<Produkt> produktList = convertProduktDTOToProduktList(kundeDTO, kunde);
        kunde.setProduktList(produktList);

        List<Rolle> rolleList = convertRolleDTOToRolleList(kundeDTO, kunde);
        kunde.setRolleList(rolleList);

        return kunde;
    }

    private static List<Rolle> convertRolleDTOToRolleList(KundeDTO kundeDTO, Kunde kunde) {

        List<RolleDTO> rolleDTOList = kundeDTO.getRolleDTOList();

        return rolleDTOList.stream()
                .map(rolleDTO -> RolleRolleDTOAssembler.convertRolleDTOToRolle(rolleDTO, kunde))
                .collect(Collectors.toList());
    }

    private static List<Produkt> convertProduktDTOToProduktList(KundeDTO kundeDTO, Kunde kunde) {

        List<ProduktDTO> produktDTOList = kundeDTO.getProduktDTOList();

        return produktDTOList.stream()
                .map(produktDTO -> ProduktProduktDTOAssembler.mapProduktDTOToProdukt(produktDTO, kunde))
                .collect(Collectors.toList());
    }

    private static List<Adresse> convertAdresseDTOToAdresseList(KundeDTO kundeDTO, Kunde kunde) {

        List<AdresseDTO> adresseList = kundeDTO.getAdresseList();

        return adresseList.stream()
                .map(adresseDTO -> AdresseAdresseDTOAssembler.mapAdresseDTOToAdresse(adresseDTO, kunde))
                .collect(Collectors.toList());
    }
}
