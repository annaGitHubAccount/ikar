package de.anna.springboot.service.fabrik;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.webservice.IkarWebServiceConfig;
import de.anna.springboot.webservice.ProduktStammdatenRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProduktStammdatenServiceFabrikWebServiceImpl implements ProduktStammdatenServiceFabrik{

    @Autowired
    private ProduktStammdatenRestClient produktStammdatenRestClient;

    @Override
    public List<ProduktStammdatenDTO> findAll() {

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenRestClient.findAll();

        return produktStammdatenDTOList;
    }
}
