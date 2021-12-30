package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Adresse;
import org.springframework.data.repository.CrudRepository;

public interface AdresseRepository extends CrudRepository<Adresse, Long> {
}
