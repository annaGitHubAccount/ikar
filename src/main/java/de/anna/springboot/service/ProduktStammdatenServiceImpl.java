package de.anna.springboot.service;

import de.anna.springboot.model.assembler.ProduktStammdatenProductStammdatenDTOAssembler;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.entity.ProduktStammdaten;
import de.anna.springboot.repository.ProduktStammdatenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProduktStammdatenServiceImpl implements ProduktStammdatenService {

    @Autowired
    ProduktStammdatenRepository produktStammdatenRepository;

    @Override
    @Transactional
    public void save(ProduktStammdatenDTO produktStammdatenDTO) {

        ProduktStammdaten produktStammdaten = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenDTOToProduktStammdaten(produktStammdatenDTO);
        produktStammdatenRepository.save(produktStammdaten);
    }

    @Override
    public List<ProduktStammdatenDTO> findAll() {

        ArrayList<ProduktStammdaten> produktStammdatenArrayList = (ArrayList<ProduktStammdaten>) produktStammdatenRepository.findAll();
        List<ProduktStammdatenDTO> produktStammdatenDTOList = new ArrayList<>();

        for(ProduktStammdaten produktStammdaten : produktStammdatenArrayList) {
            ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten);
            produktStammdatenDTOList.add(produktStammdatenDTO);
        }

        return produktStammdatenDTOList;
    }

    @Override
    public ProduktStammdatenDTO findProduktStammdatenById(Long id) {

        Optional<ProduktStammdaten> produktStammdaten = produktStammdatenRepository.findById(id);

        ProduktStammdatenDTO produktStammdatenDTO = null;
        if(produktStammdaten.isPresent()) {
            produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten.get());
        }

        return produktStammdatenDTO;
    }

    @Override
    @Transactional
    public void deleteProduktStammdatenById(Long id) {

        Optional<ProduktStammdaten> produktStammdaten = produktStammdatenRepository.findById(id);

        if(produktStammdaten.isPresent()) {
            produktStammdatenRepository.deleteById(produktStammdaten.get().getId());
        }
    }

    @Override
    public List<ProduktStammdatenDTO> findProduktStammdatenByName(String name) {

        List<ProduktStammdaten> produktStammdatenByNameList = produktStammdatenRepository.findProduktStammdatenByName(name);
        List<ProduktStammdatenDTO> produktStammdatenDTOList = new ArrayList<>();

        for(ProduktStammdaten produktStammdaten : produktStammdatenByNameList) {
            ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenProductStammdatenDTOAssembler.mapProduktStammdatenToProduktStammdatenDTO(produktStammdaten);
            produktStammdatenDTOList.add(produktStammdatenDTO);
        }

        return produktStammdatenDTOList;
    }
}
