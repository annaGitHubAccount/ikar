package de.anna.springboot.filter;

import de.anna.springboot.webservice.IkarWebServiceConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class IkarFilter implements Filter {

    private static final String ZEIGE_PRODUKT_STAMMDATEN = "zeigeProduktStammdaten";

    private final IkarWebServiceConfig ikarWebServiceConfig;

    public IkarFilter(IkarWebServiceConfig ikarWebServiceConfig) {
        this.ikarWebServiceConfig = ikarWebServiceConfig;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if(!ikarWebServiceConfig.isUseNestor()){
            httpServletRequest.setAttribute(ZEIGE_PRODUKT_STAMMDATEN, "show");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
