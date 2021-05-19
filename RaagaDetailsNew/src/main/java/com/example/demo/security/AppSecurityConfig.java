package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	//using the hardcode username and password
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("goutam").password(
	 * "1234").roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
	
	
	//using the username and password from Database
	/*
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Bean public AuthenticationProvider authProvider() {
	 * DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	 * provider.setUserDetailsService(userDetailsService);
	 * provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); return
	 * provider; }
	 */
	
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception{
		  http.csrf().disable().antMatcher("/**")
		  .authorizeRequests().antMatchers("/").permitAll()
		  .anyRequest().authenticated().and().oauth2Login();
	  }
	 

}