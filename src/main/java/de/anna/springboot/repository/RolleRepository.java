package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Rolle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RolleRepository extends CrudRepository<Rolle, Long> {

    List<Rolle> findByKundeId(Long kundeId);

    List<Rolle> findRolleByName(String name);
}
