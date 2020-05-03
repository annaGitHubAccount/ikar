package de.anna.springboot.service;


import de.anna.springboot.model.assembler.ProduktStammdatenProductStammdatenDTOAssembler;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.entity.ProduktStammdaten;
import de.anna.springboot.repository.ProduktStammdatenRepository;
import de.anna.springboot.repository.ProduktstammdatenSucheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProduktStammdatenServiceImpl implements ProduktStammdatenService {

    @Autowired
    ProduktStammdatenRepository produktStammdatenRepository;

    @Autowired
    ProduktstammdatenSucheRepository produktstammdatenSucheRepository;


    @Override
    @Transactional
    public void save(ProduktStammdatenDTO produktStammdatenDTO) {

        ProduktStammdaten produktStammdaten = null;

        if (produktStammdatenDTO.getId() == null) {

            produktStammdaten = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenDTOToProduktStammdaten(produktStammdatenDTO);


        } else {

            Optional<ProduktStammdaten> produktStammdatenOptional = produktStammdatenRepository.findById(produktStammdatenDTO.getId());

            if (produktStammdatenOptional.isPresent()) {
                produktStammdaten = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenDTOToProduktStammdaten(produktStammdatenDTO);
            }
        }

        produktStammdatenRepository.save(produktStammdaten);
    }

    @Override
    public List<ProduktStammdatenDTO> findAll() {

        ArrayList<ProduktStammdaten> produktStammdatenArrayList = (ArrayList<ProduktStammdaten>) produktStammdatenRepository.findAll();

        return produktStammdatenArrayList.stream()
                .map(produktStammdaten -> {
                    ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten);
                    return produktStammdatenDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProduktStammdatenDTO findProduktStammdatenById(Long id) {

        Optional<ProduktStammdaten> produktStammdaten = produktStammdatenRepository.findById(id);

        ProduktStammdatenDTO produktStammdatenDTO = null;
        if (produktStammdaten.isPresent()) {
            produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten.get());
        }

        return produktStammdatenDTO;
    }

    @Override
    @Transactional
    public void deleteProduktStammdatenById(Long id) {

        Optional<ProduktStammdaten> produktStammdaten = produktStammdatenRepository.findById(id);

        if (produktStammdaten.isPresent()) {
            produktStammdatenRepository.deleteById(produktStammdaten.get().getId());
        }
    }

    @Override
    public List<ProduktStammdatenDTO> findProduktStammdatenByName(String name) {

        List<ProduktStammdaten> produktStammdatenByNameList = produktStammdatenRepository.findProduktStammdatenByName(name);

        return produktStammdatenByNameList.stream()
                .map(produktStammdaten -> {
                    ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten);
                    return produktStammdatenDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduktStammdatenDTO> findProduktStammdaten(String name, BigDecimal preisAB, BigDecimal preisBIS, String symbol, Boolean aktiv) {

        List<ProduktStammdaten> produktStammdatenList = produktstammdatenSucheRepository.findProduktStammdaten(name, preisAB, preisBIS, symbol, aktiv);

        return produktStammdatenList.stream()
                .map(produktStammdaten -> {
                    ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten);
                    return produktStammdatenDTO;
                })
                .collect(Collectors.toList());
    }
}
