package com.example.demo.security;

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		/*
		 * http //.csrf().disable() .antMatcher("/**")
		 * .authorizeRequests().antMatchers("/").permitAll()
		 * .anyRequest().authenticated() .and() .oauth2Login();
		 */
		      
		     
}

}