package de.anna.springboot.service.fabrik;

import de.anna.springboot.model.assembler.ProduktStammdatenProductStammdatenDTOAssembler;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.entity.ProduktStammdaten;
import de.anna.springboot.repository.ProduktStammdatenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProduktStammdatenServiceFabrikDBImpl implements ProduktStammdatenServiceFabrik{

    @Autowired
    private ProduktStammdatenRepository produktStammdatenRepository;

    @Override
    public List<ProduktStammdatenDTO> findAll() {

        ArrayList<ProduktStammdaten> produktStammdatenArrayList = (ArrayList<ProduktStammdaten>) produktStammdatenRepository.findAll();

        return produktStammdatenArrayList.stream()
                .map(ProduktStammdatenProductStammdatenDTOAssembler::mapProduktStammdatenToProduktStammdatenDTO)
                .toList();
    }
}
