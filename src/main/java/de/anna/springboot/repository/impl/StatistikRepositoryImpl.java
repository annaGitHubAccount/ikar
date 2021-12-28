package de.anna.springboot.repository.impl;

import de.anna.springboot.model.dto.KundeAnzahlLandDTO;
import de.anna.springboot.model.dto.KundeAnzahlProProduktDTO;
import de.anna.springboot.repository.StatistikRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StatistikRepositoryImpl implements StatistikRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<KundeAnzahlLandDTO> findAnzahlVonKundenImLand() {

        List resultList = entityManager.createQuery(
                "select new de.anna.springboot.model.dto.KundeAnzahlLandDTO(adresse.land, count (kunde.id)) " +
                "from Kunde kunde join kunde.adresseList adresse " +
                "where adresse.adresseArt = de.anna.springboot.model.enums.AdresseArt.MELDEANSCHRIFT " +
                "group by adresse.land")
                .getResultList();

        return resultList;
    }

    @Override
    public List<KundeAnzahlProProduktDTO> findAnzahlVonKundenProProdukt() {

        List resultList = entityManager.createQuery(
                "select new de.anna.springboot.model.dto.KundeAnzahlProProduktDTO(produkt.name , count (produkt.kunde.id)) " +
                        "from Produkt produkt " +
                        "group by produkt.name " +
                        "order by produkt.name ASC")
                .getResultList();

        return resultList;
    }
}
