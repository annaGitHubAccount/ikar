package de.anna.springboot.repository.impl;

import de.anna.springboot.model.entity.Bundesland;
import de.anna.springboot.repository.BundeslandRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BundeslandRepositoryImpl implements BundeslandRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bundesland> findBundeslandByLand(String landSymbol) {

        Query query = entityManager.createQuery(
                "select bundesland from Bundesland bundesland where bundesland.land.symbol = :landSymbol");

        List<Bundesland> resultList = query.setParameter("landSymbol", landSymbol).getResultList();

        return resultList;
    }
}
