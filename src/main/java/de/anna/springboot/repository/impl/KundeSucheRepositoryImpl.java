package de.anna.springboot.repository.impl;

import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.repository.KundeSucheRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KundeSucheRepositoryImpl implements KundeSucheRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Kunde> findKunden(String steuerId, String nachname, String kundeArt, LocalDate geburtsdatumAB, LocalDate geburtsdatumBIS) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Kunde> criteriaQuery = criteriaBuilder.createQuery(Kunde.class);
        Root<Kunde> kundeRoot = criteriaQuery.from(Kunde.class);

        List<Predicate> predicateList = new ArrayList<>();

        if (steuerId != null && !steuerId.isEmpty()) {

            String steuerIdReplace = steuerId.replace('*', '%');
            Predicate steuerIdPredicate = criteriaBuilder.like(kundeRoot.get("steuerId"), "%" + steuerIdReplace + "%");
            predicateList.add(steuerIdPredicate);
        }

        if(nachname != null && !nachname.isEmpty()){

            String nachnameReplace = nachname.replace('*', '%');
            Predicate nachnamePredicate = criteriaBuilder.like(kundeRoot.get("nachname"), "%" + nachnameReplace + "%");
            predicateList.add(nachnamePredicate);
        }

        if(kundeArt != null && !kundeArt.isEmpty()){

            KundeArt kundeArtByKode = KundeArt.convertToKundeArtByCode(kundeArt);
            Predicate kundeArtPredicate = criteriaBuilder.equal(kundeRoot.get("kundeArt"), kundeArtByKode);
            predicateList.add(kundeArtPredicate);
        }

        if(geburtsdatumAB != null){

            Predicate birthDatePredicate = criteriaBuilder.greaterThanOrEqualTo(kundeRoot.get("birthDate"), geburtsdatumAB);
            predicateList.add(birthDatePredicate);
        }

        if(geburtsdatumBIS != null){

            Predicate birthDatePredicate = criteriaBuilder.lessThanOrEqualTo(kundeRoot.get("birthDate"), geburtsdatumBIS);
            predicateList.add(birthDatePredicate);
        }

        Predicate[] predicateArray = new Predicate[predicateList.size()];
        predicateList.toArray(predicateArray);
        criteriaQuery.where(criteriaBuilder.and(predicateArray));

        List<Kunde> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return resultList;
    }
}
