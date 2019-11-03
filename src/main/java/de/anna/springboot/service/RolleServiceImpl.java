package de.anna.springboot.service;

import de.anna.springboot.model.assembler.RolleRolleDTOAssembler;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.repository.KundeRepository;
import de.anna.springboot.repository.RolleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        return rollenListByKunde.stream()
                .map(rolle -> {
                    RolleDTO rolleDTO = RolleRolleDTOAssembler.convertRolleToRolleDTO(rolle);
                    return rolleDTO;
                })
                .collect(Collectors.toList());
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
    public void save(RolleDTO rolleDTO) {

        if (rolleDTO.getId() == null) {

            Optional<Kunde> optionalKunde = kundeRepository.findById(rolleDTO.getKundeId());

            Rolle rolle = null;
            if (optionalKunde.isPresent()) {

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

    @Override
    public List<RolleDTO> findRolleByName(String name) {

        List<Rolle> rolleByNameList = rolleRepository.findRolleByName(name);

        return rolleByNameList.stream().map(rolle -> RolleRolleDTOAssembler.convertRolleToRolleDTO(rolle))
                .collect(Collectors.toList());
    }
}
