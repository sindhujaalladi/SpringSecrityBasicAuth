package com.springsecuritybasicauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
	 throws Exception { 
		auth.inMemoryAuthentication().withUser("javasecure").password("{noop}password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("sindhu").password("{noop}pass123").roles("USER");
		}
	
	
	
	//below code represents any request which hits this api it has to be fully authenthicated.
	
	/*
	 * @Override protected void configure (HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	 * }
	 */
	
	
	// below code represents any request URI which starts from REST it has to be full authenthicated.
	/*
	 * @Override protected void configure (HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().
	 * httpBasic();
	 * 
	 * }
	 */
	
	// below code represents any request uri which starts from rest has authorized with ADMIN role and it has to be fully authenthicated.
	 
	 @Override 
	 protected void configure (HttpSecurity http) throws Exception {
		 http.csrf().disable();
		 http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();

	 }

	
	
	public static NoOpPasswordEncoder passwordencoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	

}
