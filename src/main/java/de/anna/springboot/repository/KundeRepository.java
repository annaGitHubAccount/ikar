package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Kunde;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KundeRepository extends CrudRepository<Kunde, Long> {

    List<Kunde> findKundeByNachname(String nacrudhname);
}
