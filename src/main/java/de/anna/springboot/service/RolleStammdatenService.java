package de.anna.springboot.service;

import de.anna.springboot.model.dto.RolleStammdatenDTO;

import java.util.List;

public interface RolleStammdatenService {

    void save(RolleStammdatenDTO rolleStammdatenDTO);

    List<RolleStammdatenDTO> findAll();

    RolleStammdatenDTO findRolleDTOStammdatenById(Long id);

    void deleteRolleStammdatenDTOById(Long id);
}
