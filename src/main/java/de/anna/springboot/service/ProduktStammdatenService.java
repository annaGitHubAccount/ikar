package de.anna.springboot.service;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;

import java.util.List;

public interface ProduktStammdatenService {

    void save(ProduktStammdatenDTO produktStammdatenDTO);

    List<ProduktStammdatenDTO> findAll();

    ProduktStammdatenDTO findProduktStammdatenById(Long id);

    void deleteProduktStammdatenById(Long id);

    List<ProduktStammdatenDTO> findProduktStammdatenByName(String name);
}
