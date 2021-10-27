package com.taimur.hospital.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HospitalAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
      throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm="+ getRealmName() + "");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        log.error("Validation failed , not authorize."+authEx.getMessage());
        writer.println("Not Authorize");
        
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("HMIS");
        super.afterPropertiesSet();
    }
}