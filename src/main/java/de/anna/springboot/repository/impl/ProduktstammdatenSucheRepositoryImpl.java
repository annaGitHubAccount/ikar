package de.anna.springboot.repository.impl;

import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.ProduktStammdaten;
import de.anna.springboot.repository.ProduktstammdatenSucheRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProduktstammdatenSucheRepositoryImpl implements ProduktstammdatenSucheRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProduktStammdaten> findProduktStammdaten(String name, BigDecimal preisAB, BigDecimal preisBIS, String symbol, Boolean isAktiv) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProduktStammdaten> criteriaQuery = criteriaBuilder.createQuery(ProduktStammdaten.class);
        Root<ProduktStammdaten> produktStammdatenRoot = criteriaQuery.from(ProduktStammdaten.class);

        List<Predicate> predicateList = new ArrayList<>();

        if(!StringUtils.isEmpty(name)){

            String nachnameReplace = name.replace('*', '%');
            Predicate namePredicate = criteriaBuilder.like(produktStammdatenRoot.get("name"), "%" + nachnameReplace + "%");
            predicateList.add(namePredicate);
        }

        if(preisAB != null){

            Predicate preisABPredicate = criteriaBuilder.greaterThanOrEqualTo(produktStammdatenRoot.get("preis"), preisAB);
            predicateList.add(preisABPredicate);
        }

        if(preisBIS != null){

            Predicate preisBISPredicate = criteriaBuilder.lessThanOrEqualTo(produktStammdatenRoot.get("preis"), preisBIS);
            predicateList.add(preisBISPredicate);
        }

        if(!StringUtils.isEmpty(symbol)){

            String symbolReplace = symbol.replace('*', '%');
            Predicate symbolPredicate = criteriaBuilder.like(produktStammdatenRoot.get("symbol"), "%" + symbolReplace + "%");
            predicateList.add(symbolPredicate);
        }

        if(isAktiv != null){

            Predicate aktivPredicate = criteriaBuilder.equal(produktStammdatenRoot.get("aktiv"), isAktiv);
            predicateList.add(aktivPredicate);
        }

        Predicate[] predicateArray = new Predicate[predicateList.size()];
        predicateList.toArray(predicateArray);
        criteriaQuery.where(criteriaBuilder.and(predicateArray));

        List<ProduktStammdaten> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return resultList;
    }
}
