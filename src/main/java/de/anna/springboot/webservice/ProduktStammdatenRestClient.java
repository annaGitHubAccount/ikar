package de.anna.springboot.webservice;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProduktStammdatenRestClient {

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
