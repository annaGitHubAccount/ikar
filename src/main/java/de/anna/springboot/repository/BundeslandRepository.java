package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Bundesland;
import de.anna.springboot.model.entity.Land;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BundeslandRepository {

    List<Bundesland> findBundeslandByLand(String landName);
}
