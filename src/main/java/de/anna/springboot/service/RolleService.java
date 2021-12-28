package de.anna.springboot.service;

import de.anna.springboot.model.dto.RolleDTO;

import java.util.List;

public interface RolleService {

    List<RolleDTO> findByKundeId(Long kundeId);

    RolleDTO findRolleById(Long id);

    void deleteRolleById(Long id);

    void save(RolleDTO rolleDTO);

    List<RolleDTO> findRolleByName(String name);
}
