package de.anna.springboot.service;

import de.anna.springboot.model.assembler.OrtDTOOrtAssembler;
import de.anna.springboot.model.dto.OrtDTO;
import de.anna.springboot.model.entity.Ort;
import de.anna.springboot.repository.OrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrtServiceImpl implements OrtService{

    @Autowired
    OrtRepository ortRepository;

    @Override
    public List<OrtDTO> findOrtByBundesland(String bundeslandName) {

        List<Ort> ortByBundesland = ortRepository.findOrtByBundesland(bundeslandName);

        return ortByBundesland.stream()
                .map(OrtDTOOrtAssembler::convertOrtToOrtTDO)
                .toList();
    }
}
