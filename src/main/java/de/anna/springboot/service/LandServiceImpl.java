package de.anna.springboot.service;

import de.anna.springboot.model.assembler.LandDTOLandAssembler;
import de.anna.springboot.model.dto.LandDTO;
import de.anna.springboot.model.entity.Land;
import de.anna.springboot.repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandServiceImpl implements LandService {

    @Autowired
    private LandRepository landRepository;

    @Override
    public List<LandDTO> findAll() {

        List<Land> landDTOList = (List<Land>) landRepository.findAll();

        return landDTOList.stream()
                .map(land -> LandDTOLandAssembler.mapLandToLandDTO(land))
                .collect(Collectors.toList());
    }

    @Override
    public LandDTO findLandBySymbol(String symbol) {

        Land land = landRepository.findLandBySymbol(symbol);
        LandDTO landDTO = LandDTOLandAssembler.mapLandToLandDTO(land);

        return landDTO;
    }


}
