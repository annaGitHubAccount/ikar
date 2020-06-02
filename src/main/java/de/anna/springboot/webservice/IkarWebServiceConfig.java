package de.anna.springboot.webservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ikar")
public class IkarWebServiceConfig {

    private boolean useNestor;


    public boolean isUseNestor() {
        return useNestor;
    }

    public void setUseNestor(String useNestor) {
        this.useNestor = Boolean.parseBoolean(useNestor);
    }
}
