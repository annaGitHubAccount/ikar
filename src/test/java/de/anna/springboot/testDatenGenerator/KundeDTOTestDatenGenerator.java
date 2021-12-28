package de.anna.springboot.testDatenGenerator;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.enums.AdresseArt;
import de.anna.springboot.util.DateUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KundeDTOTestDatenGenerator {


    public static KundeDTO erstellBeispielhaftenKundenDTO(){

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId((long) 1);
        kundeDTO.setKundeNummer("2003K0006");
        kundeDTO.setName("Adam");
        kundeDTO.setNachname("Niezgodka");

        LocalDate localDate = DateUtils.stringToLocalDate("23.10.1999");
        kundeDTO.setBirthDate(localDate);

        kundeDTO.setSteuerId("123456789");

        AdresseDTO adressePostanschrift = erstellAdresseDTO(AdresseArt.POSTANSCHRIFT, "2", "Lange Str.", "Nürnberg");
        AdresseDTO adresseMeldeadresse = erstellAdresseDTO(AdresseArt.MELDEANSCHRIFT, "4", "Hauptstrasse", "München");
        List<AdresseDTO> adresseList = new ArrayList<>();
        adresseList.add(adresseMeldeadresse);
        adresseList.add(adressePostanschrift);
        kundeDTO.setAdresseList(adresseList);

        ProduktDTO produkt1 = erstellProduktDTO("Produkt1", true, BigDecimal.valueOf(100));
        ProduktDTO produkt2 = erstellProduktDTO("Produkt2", false, BigDecimal.valueOf(100));
        List<ProduktDTO> listProdukt = new ArrayList<>();
        listProdukt.add(produkt1);
        listProdukt.add(produkt2);
        kundeDTO.setProduktDTOList(listProdukt);

        RolleDTO rolle1 = new RolleDTO();
        rolle1.setId((long) 1);
        rolle1.setName("Scrim Master");
        rolle1.setKundeDTO(kundeDTO);

        RolleDTO rolle2 = new RolleDTO();
        rolle2.setId((long) 2);
        rolle2.setName("Entwickler");
        rolle2.setKundeDTO(kundeDTO);

        List<RolleDTO> rolleList = new ArrayList<>();
        rolleList.add(rolle1);
        rolleList.add(rolle2);
        kundeDTO.setRolleDTOList(rolleList);

        return kundeDTO;
    }


    private static AdresseDTO erstellAdresseDTO(AdresseArt adresseArt, String hausNr, String strasse, String ort){

        AdresseDTO adresseDTO = new AdresseDTO();

        adresseDTO.setAdresseArt(adresseArt);
        adresseDTO.setHausNr(hausNr);
        adresseDTO.setStrasse(strasse);
        adresseDTO.setOrt(ort);

        return adresseDTO;
    }

    private static ProduktDTO erstellProduktDTO(String name, boolean aktiv, BigDecimal preis){

        ProduktDTO produktDTO = new ProduktDTO();
        produktDTO.setName(name);
        produktDTO.setAktiv(aktiv);
        produktDTO.setPreis(preis);

        return produktDTO;
    }
}
