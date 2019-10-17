package de.anna.springboot.service;

import de.anna.springboot.model.assembler.RolleRolleDTOAssembler;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.repository.RolleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolleServiceImpl implements RolleService {


    @Autowired
    RolleRepository rolleRepository;

    @Override
    @Transactional
    public List<de.anna.springboot.model.dto.RolleDTO> findByKundeId(Long kundeId) {

        List<Rolle> rollenListByKunde = rolleRepository.findByKundeId(kundeId);
        List<de.anna.springboot.model.dto.RolleDTO> rolleDTOListByKunde = new ArrayList<>();

        for (Rolle rolle : rollenListByKunde) {
            de.anna.springboot.model.dto.RolleDTO rolleDTO = RolleRolleDTOAssembler.convertRolleToRolleDTO(rolle);
            rolleDTOListByKunde.add(rolleDTO);
        }

        return rolleDTOListByKunde;
    }

    @Override
    @Transactional
    public de.anna.springboot.model.dto.RolleDTO findRolleById(Long id) {

        Optional<Rolle> rolleById = rolleRepository.findById(id);

        de.anna.springboot.model.dto.RolleDTO rolleDTO = new de.anna.springboot.model.dto.RolleDTO();
        if (rolleById.isPresent()) {
            rolleDTO = RolleRolleDTOAssembler.convertRolleToRolleDTO(rolleById.get());
        }

        return rolleDTO;
    }

    @Override
    @Transactional
    public void deleteRolleById(Long id) {

        Optional<Rolle> rolleById = rolleRepository.findById(id);

        if (rolleById.isPresent()) {
            rolleRepository.delete(rolleById.get());
        }
    }

    @Override
    @Transactional
    public void save(de.anna.springboot.model.dto.RolleDTO rolleDTO) {

        Optional<Rolle> rolleOptional = rolleRepository.findById(rolleDTO.getId());

        Rolle rolle = null;
        if(rolleOptional.isPresent()){
            rolle = rolleOptional.get();
            rolle.setName(rolleDTO.getName());
        }

        rolleRepository.save(rolle);
    }
}
