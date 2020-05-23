package de.anna.springboot.repository.impl;

import de.anna.springboot.model.entity.Ort;
import de.anna.springboot.repository.OrtRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OrtRepositoryImpl implements OrtRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ort> findOrtByBundesland(String bundeslandName) {

        Query query = entityManager.createQuery(
                "select ort from Ort ort where ort.bundesland.name = :bundeslandName");

        List<Ort> resultList = query.setParameter("bundeslandName", bundeslandName).getResultList();

        return resultList;
    }
}
