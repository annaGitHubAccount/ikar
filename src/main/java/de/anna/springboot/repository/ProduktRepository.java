package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Produkt;
import org.springframework.data.repository.CrudRepository;

public interface ProduktRepository extends CrudRepository<Produkt, Long> {
}
