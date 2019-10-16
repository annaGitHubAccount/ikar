package de.anna.springboot.service;

import de.anna.springboot.model.dto.RolleDTO;

import java.util.List;

public interface RolleService {

    void save(RolleDTO rolleDTO);

    List<RolleDTO> find();


}
