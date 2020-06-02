package de.anna.springboot.service.fabrik;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.webservice.NestorWebServiceConfig;
import de.anna.springboot.webservice.ProduktStammdatenListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ProduktStammdatenServiceFabrikWebServiceImpl implements ProduktStammdatenServiceFabrik {

    @Autowired
    private NestorWebServiceConfig nestorWebServiceConfig;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<ProduktStammdatenDTO> findAll() {

        List<ProduktStammdatenDTO> produktStammdatenDTOList = new ArrayList<>();

        String urlVomNestor = gibURLVomNestorZurueck();

        ProduktStammdatenListResponse response = restTemplate.getForObject(urlVomNestor + "/produktstammdaten", ProduktStammdatenListResponse.class);
        if (response != null) {
            produktStammdatenDTOList = response.getProduktStammdatenDTOList();
        }

        return produktStammdatenDTOList;
    }

    private String gibURLVomNestorZurueck() {

        String host = nestorWebServiceConfig.getHost();
        String port = nestorWebServiceConfig.getPort();

        return "http://" + host + ":" + port;
    }
}
