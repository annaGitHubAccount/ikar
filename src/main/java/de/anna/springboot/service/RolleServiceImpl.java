package de.anna.springboot.service;

import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.repository.RolleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolleServiceImpl implements RolleService {


    @Autowired
    RolleRepository rolleRepository;

    @Override
    @Transactional
    public void save(RolleDTO rolleDTO) {



    }

    @Override
    public List<RolleDTO> find() {
        return null;
    }
}
