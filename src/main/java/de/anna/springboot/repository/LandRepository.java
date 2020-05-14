package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Land;
import org.springframework.data.repository.CrudRepository;

public interface LandRepository extends CrudRepository<Land, Long> {

    Land findLandBySymbol(String symbol);
}
