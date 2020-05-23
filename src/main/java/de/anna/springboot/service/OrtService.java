package de.anna.springboot.service;

import de.anna.springboot.model.dto.OrtDTO;

import java.util.List;

public interface OrtService {

    List<OrtDTO> findOrtByBundesland(String bundeslandName);
}
