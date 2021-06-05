package com.tweetapp.userservice.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author Nithya T 
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/api/v1.0/tweets/").permitAll()
		.antMatchers("/swagger-ui.html").permitAll();
//				.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
