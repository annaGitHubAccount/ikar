package de.anna.springboot.service;

import de.anna.springboot.model.assembler.KundeKundeDTOAssembler;
import de.anna.springboot.model.assembler.RolleRolleDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.repository.KundeRepository;
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

    @Autowired
    KundeRepository kundeRepository;


    @Override
    @Transactional
    public List<RolleDTO> findByKundeId(Long kundeId) {

        List<Rolle> rollenListByKunde = rolleRepository.findByKundeId(kundeId);
        List<RolleDTO> rolleDTOListByKunde = new ArrayList<>();

        for (Rolle rolle : rollenListByKunde) {
            RolleDTO rolleDTO = RolleRolleDTOAssembler.convertRolleToRolleDTO(rolle);
            rolleDTOListByKunde.add(rolleDTO);
        }

        return rolleDTOListByKunde;
    }

    @Override
    @Transactional
    public RolleDTO findRolleById(Long id) {

        Optional<Rolle> rolleById = rolleRepository.findById(id);

        RolleDTO rolleDTO = new RolleDTO();
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
    public void save(RolleDTO rolleDTO, Long kundeId) {

        if (rolleDTO.getId() == null) {

            Optional<Kunde> optionalKunde = kundeRepository.findById(kundeId);

            Rolle rolle = null;
            if(optionalKunde.isPresent()) {

                rolle = RolleRolleDTOAssembler.convertRolleDTOToRolle(rolleDTO);
                Kunde kunde = optionalKunde.get();
                rolle.setKunde(kunde);

                kunde.getRolleList().add(rolle);
            }

            rolleRepository.save(rolle);

        } else {

            Optional<Rolle> rolleOptional = rolleRepository.findById(rolleDTO.getId());

            Rolle rolle = null;
            if (rolleOptional.isPresent()) {
                rolle = rolleOptional.get();
                rolle.setName(rolleDTO.getName());
            }

            rolleRepository.save(rolle);
        }
    }
}
