package com.taimur.hospital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity(debug = false)
@Slf4j
public class HospitalWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	HospitalAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	AuthenticationManagerBuilder auth; 
	
	@Autowired
	HospitalAuthenticationProvider customAuthenticationProvider;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	http.csrf().disable().authorizeRequests()
    	  .antMatchers("/login/**").authenticated()
          .antMatchers("**").permitAll()
          .anyRequest().authenticated()
          .and()
          .httpBasic()
          .authenticationEntryPoint(authenticationEntryPoint).and().authenticationProvider(customAuthenticationProvider);
         // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
