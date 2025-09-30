package com.santiago.cars.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    /**
        * Interceptor para registrar llamadas al endpoint de listado de automóviles.
     * @param request  la solicitud HTTP
     * @param response la respuesta HTTP
     * @param handler  el manejador de la solicitud
     * @return true para continuar con la cadena de manejo
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getRequestURI().contains("/api/cars") && request.getMethod().equals("GET")) {
            System.out.println("Llamada al endpoint de listado de automóviles: " + request.getRequestURI());
        }
        return true;
    }
}
