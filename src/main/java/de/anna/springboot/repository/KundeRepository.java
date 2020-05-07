package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Kunde;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KundeRepository extends CrudRepository<Kunde, Long> {

    List<Kunde> findKundeByNachname(String nachname);

    @Query(value = "SELECT nextval('kunde_nummer_seq')", nativeQuery = true)
    Long getKundeNummerSequence();
}
