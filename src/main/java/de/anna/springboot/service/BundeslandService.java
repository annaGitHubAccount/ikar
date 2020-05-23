package de.anna.springboot.service;

import de.anna.springboot.model.dto.BundeslandDTO;
import de.anna.springboot.model.dto.LandDTO;

import java.util.List;

public interface BundeslandService {

    List<BundeslandDTO> findBundeslandByLand(String landName);
}
