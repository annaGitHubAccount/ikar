package de.anna.springboot.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public class IkarInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Principal userPrincipal = request.getUserPrincipal();
        if(userPrincipal != null && modelAndView != null) {
            String userName = userPrincipal.getName();
            modelAndView.getModel().put("loggedUser", userName);
        }
    }
}
