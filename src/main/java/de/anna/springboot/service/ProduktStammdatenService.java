package de.anna.springboot.service;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.entity.ProduktStammdaten;

import java.math.BigDecimal;
import java.util.List;

public interface ProduktStammdatenService {

    void save(ProduktStammdatenDTO produktStammdatenDTO);

    List<ProduktStammdatenDTO> findAll();

    ProduktStammdatenDTO findProduktStammdatenById(Long id);

    void deleteProduktStammdatenById(Long id);

    List<ProduktStammdatenDTO> findProduktStammdatenByName(String name);

    List<ProduktStammdatenDTO> findProduktStammdaten(String name, BigDecimal preisAB, BigDecimal preisBIS, String symbol, Boolean aktiv);
}
