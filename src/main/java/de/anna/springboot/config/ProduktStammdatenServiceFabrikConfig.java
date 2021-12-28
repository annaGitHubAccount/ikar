package de.anna.springboot.config;

import de.anna.springboot.service.fabrik.ProduktStammdatenServiceFabrik;
import de.anna.springboot.service.fabrik.ProduktStammdatenServiceFabrikDBImpl;
import de.anna.springboot.service.fabrik.ProduktStammdatenServiceFabrikWebServiceImpl;
import de.anna.springboot.webservice.IkarWebServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProduktStammdatenServiceFabrikConfig {

    @Autowired
    IkarWebServiceConfig ikarWebServiceConfig;

    @Bean
    public ProduktStammdatenServiceFabrik getProduktStammdatenServiceFabrikImpl(){

        if (ikarWebServiceConfig.isUseNestor()) {

            return new ProduktStammdatenServiceFabrikWebServiceImpl();

        } else {

            return new ProduktStammdatenServiceFabrikDBImpl();
        }
    }

}
