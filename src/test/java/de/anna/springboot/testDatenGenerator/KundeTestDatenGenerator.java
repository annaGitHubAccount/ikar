package de.anna.springboot.testDatenGenerator;

import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import de.anna.springboot.model.enums.AdresseArt;
import de.anna.springboot.util.DateUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KundeTestDatenGenerator {

    public static Kunde erstellBeispielhaftenKunden1(){

        Kunde kunde = new Kunde();

        kunde.setId((long) 1);
        kunde.setKundeNummer((long) 1);
        kunde.setName("Adam");
        kunde.setNachname("Niezgodka");

        LocalDate localDate = DateUtils.stringToLocalDate("23.10.1999");
        kunde.setBirthDate(localDate);

        kunde.setSteuerId("123456789");

        Adresse adressePostanschrift = erstellAdresse(AdresseArt.POSTANSCHRIFT, "2", "Lange Str.", "Nürnberg");
        Adresse adresseMeldeadresse = erstellAdresse(AdresseArt.MELDEANSCHRIFT, "4", "Hauptstrasse", "München");
        List<Adresse> adresseList = new ArrayList<>();
        adresseList.add(adresseMeldeadresse);
        adresseList.add(adressePostanschrift);
        kunde.setAdresseList(adresseList);

        Produkt produkt1 = erstellProdukt("Produkt1", true, BigDecimal.valueOf(100));
        Produkt produkt2 = erstellProdukt("Produkt2", false, BigDecimal.valueOf(100));
        List<Produkt> listProdukt = new ArrayList<>();
        listProdukt.add(produkt1);
        listProdukt.add(produkt2);
        kunde.setProduktList(listProdukt);

        return kunde;
    }


    public static Kunde erstellBeispielhaftenKunden2(){

        Kunde kunde = new Kunde();

        kunde.setId((long) 1);
        kunde.setKundeNummer((long) 1);
        kunde.setName("Agata");
        kunde.setNachname("Maciag");

        LocalDate localDate = DateUtils.stringToLocalDate("16.08.1985");
        kunde.setBirthDate(localDate);

        kunde.setSteuerId("258963214");

        Adresse adressePostanschrift = erstellAdresse(AdresseArt.POSTANSCHRIFT, "7", "Bahnhofstr.", "Hamburg");
        Adresse adresseMeldeadresse = erstellAdresse(AdresseArt.MELDEANSCHRIFT, "4", "Rosastr.", "Köln");
        List<Adresse> adresseList = new ArrayList<>();
        adresseList.add(adresseMeldeadresse);
        adresseList.add(adressePostanschrift);
        kunde.setAdresseList(adresseList);

        Produkt produkt1 = erstellProdukt("Produkt1", true, BigDecimal.valueOf(800));
        Produkt produkt2 = erstellProdukt("Produkt2", false, BigDecimal.valueOf(500));
        List<Produkt> listProdukt = new ArrayList<>();
        listProdukt.add(produkt1);
        listProdukt.add(produkt2);
        kunde.setProduktList(listProdukt);

        return kunde;
    }


    private static Adresse erstellAdresse(AdresseArt adresseArt, String hausNr, String strasse, String ort){

        Adresse adresse = new Adresse();

        adresse.setAdresseArt(adresseArt);
        adresse.setHausNr(hausNr);
        adresse.setStrasse(strasse);
        adresse.setOrt(ort);

        return adresse;
    }

    private static Produkt erstellProdukt(String name, boolean aktiv, BigDecimal preis){

        Produkt produkt = new Produkt();
        produkt.setName(name);
        produkt.setAktiv(aktiv);
        produkt.setPreis(preis);

        return produkt;
    }
}
