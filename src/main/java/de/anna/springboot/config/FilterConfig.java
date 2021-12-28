package de.anna.springboot.config;

import de.anna.springboot.filter.IkarFilter;
import de.anna.springboot.webservice.IkarWebServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private IkarWebServiceConfig ikarWebServiceConfig;

    @Bean
    public FilterRegistrationBean<IkarFilter> ikarFilterRegistrationBean(){

        FilterRegistrationBean<IkarFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(ikarFilter());
        registrationBean.addUrlPatterns("/ikar/*");

        return registrationBean;
    }

    @Bean
    public IkarFilter ikarFilter() {
        return new IkarFilter(ikarWebServiceConfig);
    }
}
