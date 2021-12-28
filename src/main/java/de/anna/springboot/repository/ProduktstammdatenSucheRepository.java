package de.anna.springboot.repository;

import de.anna.springboot.model.entity.ProduktStammdaten;

import java.math.BigDecimal;
import java.util.List;

public interface ProduktstammdatenSucheRepository {

    List<ProduktStammdaten> findProduktStammdaten(String name, BigDecimal preisAB, BigDecimal preisBIS, String symbol, Boolean aktiv);
}
