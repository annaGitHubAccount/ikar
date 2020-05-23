package de.anna.springboot.service;

import de.anna.springboot.model.assembler.BundeslandDTOBundeslandAssembler;
import de.anna.springboot.model.assembler.LandDTOLandAssembler;
import de.anna.springboot.model.dto.BundeslandDTO;
import de.anna.springboot.model.dto.LandDTO;
import de.anna.springboot.model.entity.Bundesland;
import de.anna.springboot.model.entity.Land;
import de.anna.springboot.repository.BundeslandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BundeslandServiceImpl implements BundeslandService {


    @Autowired
    private BundeslandRepository bundeslandRepository;

    @Override
    public List<BundeslandDTO> findBundeslandByLand(String landSymbol) {

        List<Bundesland> bundeslandList = bundeslandRepository.findBundeslandByLand(landSymbol);

        List<BundeslandDTO> bundeslandDTOList = bundeslandList.stream()
                .map(bundesland -> BundeslandDTOBundeslandAssembler.convertBundeslandToBundeslandDTO(bundesland))
                .collect(Collectors.toList());

        return bundeslandDTOList;
    }
}
