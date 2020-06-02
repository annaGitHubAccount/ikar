package de.anna.springboot.service.fabrik;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;

import java.util.List;

public interface ProduktStammdatenServiceFabrik {

    List<ProduktStammdatenDTO> findAll();
}
