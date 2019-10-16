package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;

import java.util.List;

public interface RolleService {

    List<RolleDTO> findByKundeId(Long kundeId);


}
