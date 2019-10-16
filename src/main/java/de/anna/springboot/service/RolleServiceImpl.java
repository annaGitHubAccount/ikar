package de.anna.springboot.service;

import de.anna.springboot.model.assembler.RolleRolleDTOAssembler;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.repository.RolleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolleServiceImpl implements RolleService {


    @Autowired
    RolleRepository rolleRepository;

    @Override
    public List<RolleDTO> findByKundeId(Long kundeId) {

        List<Rolle> rollenListByKunde = rolleRepository.findByKundeId(kundeId);
        List<RolleDTO> rolleDTOListByKunde = new ArrayList<>();

        for (Rolle rolle : rollenListByKunde) {
            RolleDTO rolleDTO = RolleRolleDTOAssembler.convertRolleToRolleDTO(rolle);
            rolleDTOListByKunde.add(rolleDTO);
        }

        return rolleDTOListByKunde;
    }
}
