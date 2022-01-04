package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import de.anna.springboot.testDatenGenerator.KundeDTOTestDatenGenerator;
import de.anna.springboot.testDatenGenerator.KundeTestDatenGenerator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class KundeKundeDTOAssemblerTest {

    private static Kunde kunde;
    private static KundeDTO kundeDTO;

    @BeforeAll
    public static void erstellenVonKundeEntity(){

        kunde = KundeTestDatenGenerator.erstellBeispielhaftenKunden1();
        kundeDTO = KundeDTOTestDatenGenerator.erstellBeispielhaftenKundenDTO();
    };


    @Test
    public void shouldMapKundeToKundeDTO(){

        KundeDTO kundeDTO = KundeKundeDTOAssembler.mapKundeToKundeDTO(kunde);

        assertEquals(kunde.getId(), kundeDTO.getId());
        assertEquals(kunde.getSteuerId(), kundeDTO.getSteuerId());
        assertEquals(kunde.getBirthDate(), kundeDTO.getBirthDate());
        assertEquals(kunde.getKundeArt(), kundeDTO.getKundeArt());
        assertEquals(kunde.getName(), kundeDTO.getName());
        assertEquals(kunde.getNachname(), kundeDTO.getNachname());
        assertEquals(kunde.getKundeNummer(), kundeDTO.getKundeNummer());
        assertProduktList(kunde.getProduktList(), kundeDTO.getProduktDTOList());
        assertAdresseList(kunde.getAdresseList(), kundeDTO.getAdresseList());
    }


    @Test
    public void shouldMapKundeDTOToKunde(){

        Kunde kundeEntity = KundeKundeDTOAssembler.mapKundeDTOToKunde(kundeDTO, kunde);

        assertEquals(kundeDTO.getId(), kundeEntity.getId());
        assertEquals(kundeDTO.getSteuerId(), kundeEntity.getSteuerId());
        assertEquals(kundeDTO.getBirthDate(), kundeEntity.getBirthDate());
        assertEquals(kundeDTO.getKundeArt(), kundeEntity.getKundeArt());
        assertEquals(kundeDTO.getName(), kundeEntity.getName());
        assertEquals(kundeDTO.getNachname(), kundeEntity.getNachname());
        assertEquals(kundeDTO.getKundeNummer(), kundeEntity.getKundeNummer());
        assertProduktDTOList(kundeDTO.getProduktDTOList(), kundeEntity.getProduktList());
        assertAdresseDTOList(kundeDTO.getAdresseList(), kundeEntity.getAdresseList());
    }



    private void assertAdresseDTOList(List<AdresseDTO> adresseDTOList, List<Adresse> adresseList) {

        for(int i = 0; i < adresseDTOList.size(); i++){

            AdresseDTO adresseDTO = adresseDTOList.get(i);
            Adresse adresse = adresseList.get(i);

            assertEquals(adresseDTO.getAdresseArt(), adresse.getAdresseArt());
            assertEquals(adresseDTO.getHausNr(), adresse.getHausNr());
            assertEquals(adresseDTO.getStrasse(), adresse.getStrasse());
            assertEquals(adresseDTO.getOrt(), adresse.getOrt());
        }
    }

    private void assertProduktDTOList(List<ProduktDTO> produktDTOList, List<Produkt> produktList) {

        for(int i = 0; i < produktDTOList.size(); i++){

            ProduktDTO produktDTO = produktDTOList.get(i);
            Produkt produkt = produktList.get(i);

            assertEquals(produktDTO.getName(), produkt.getName());
            assertEquals(produktDTO.getPreis(), produkt.getPreis());
            assertEquals(produktDTO.isAktiv(), produkt.isAktiv());
        }

    }


    private void assertAdresseList(List<Adresse> adresseList, List<AdresseDTO> adresseDTOList) {

        for(int i = 0; i < adresseList.size(); i++){

            Adresse adresse = adresseList.get(i);
            AdresseDTO adresseDTO = adresseDTOList.get(i);

            assertEquals(adresse.getAdresseArt(), adresseDTO.getAdresseArt());
            assertEquals(adresse.getHausNr(), adresseDTO.getHausNr());
            assertEquals(adresse.getStrasse(), adresseDTO.getStrasse());
            assertEquals(adresse.getOrt(), adresseDTO.getOrt());
        }
    }

    private void assertProduktList(List<Produkt> produktList, List<ProduktDTO> produktDTOList) {

        for(int i = 0; i < produktList.size(); i++ ){

            Produkt produkt = produktList.get(i);
            ProduktDTO produktDTO = produktDTOList.get(i);

            assertEquals(produkt.getName(), produktDTO.getName());
            assertEquals(produkt.getPreis(), produktDTO.getPreis());
            assertEquals(produkt.isAktiv(), produktDTO.isAktiv());
        }
    }









}
