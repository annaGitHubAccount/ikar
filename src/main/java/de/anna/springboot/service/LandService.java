package de.anna.springboot.service;


import de.anna.springboot.model.dto.LandDTO;

import java.util.List;

public interface LandService {

    List<LandDTO> findAll();

    LandDTO findLandBySymbol(String symbol);

}
