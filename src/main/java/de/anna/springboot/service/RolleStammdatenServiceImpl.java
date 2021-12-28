package de.anna.springboot.service;

import de.anna.springboot.model.assembler.RolleStammdatenRolleStammdatenDTOAssembler;
import de.anna.springboot.model.dto.RolleStammdatenDTO;
import de.anna.springboot.model.entity.RolleStammdaten;
import de.anna.springboot.repository.RolleStammdatenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolleStammdatenServiceImpl implements RolleStammdatenService {

    @Autowired
    RolleStammdatenRepository rolleStammdatenRepository;


    @Override
    @Transactional
    public void save(RolleStammdatenDTO rolleStammdatenDTO) {

        RolleStammdaten rolleStammdaten = null;

        if (rolleStammdatenDTO.getId() == null) {
            rolleStammdaten = RolleStammdatenRolleStammdatenDTOAssembler.convertRolleStammdatenDTOToRolleStammdaten(rolleStammdatenDTO);

        } else {
            Optional<RolleStammdaten> rolleOptional = rolleStammdatenRepository.findById(rolleStammdatenDTO.getId());

            if (rolleOptional.isPresent()) {
                rolleStammdaten = RolleStammdatenRolleStammdatenDTOAssembler.convertRolleStammdatenDTOToRolleStammdaten(rolleStammdatenDTO);
            }
        }

        rolleStammdatenRepository.save(rolleStammdaten);

    }

    @Override
    public List<RolleStammdatenDTO> findAll() {

        ArrayList<RolleStammdaten> rolleStammdatenArrayList = (ArrayList<RolleStammdaten>) rolleStammdatenRepository.findAll();

        return rolleStammdatenArrayList.stream()
                .map(RolleStammdatenRolleStammdatenDTOAssembler::convertRolleStammdatenToRolleStammdatenDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RolleStammdatenDTO findRolleDTOStammdatenById(Long id) {

        Optional<RolleStammdaten> rolleStammdatenOptional = rolleStammdatenRepository.findById(id);

        RolleStammdatenDTO rolleStammdatenDTO = null;
        if(rolleStammdatenOptional.isPresent()){
            rolleStammdatenDTO = RolleStammdatenRolleStammdatenDTOAssembler.convertRolleStammdatenToRolleStammdatenDTO(rolleStammdatenOptional.get());
        }

        return rolleStammdatenDTO;
    }

    @Override
    @Transactional
    public void deleteRolleStammdatenDTOById(Long id) {

        Optional<RolleStammdaten> rolleStammdatenOptional = rolleStammdatenRepository.findById(id);

        rolleStammdatenOptional.ifPresent(rolleStammdaten -> rolleStammdatenRepository.delete(rolleStammdaten));
    }
}
