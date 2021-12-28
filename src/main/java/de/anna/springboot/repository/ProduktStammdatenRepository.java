package de.anna.springboot.repository;

import de.anna.springboot.model.entity.ProduktStammdaten;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProduktStammdatenRepository extends CrudRepository<ProduktStammdaten, Long> {

    List<ProduktStammdaten> findProduktStammdatenByName(String name);

}
