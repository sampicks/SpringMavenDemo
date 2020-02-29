package com.peeyoosh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfiguration file to authenticate users, hence there is no use of LoginSpringMvc.jsp because 
 * not security is managing by spring itself.
 * @author peeyooshkhare
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		/**
		 * valid user to access application and what are their roles, all these we define here.
		 */
		auth.inMemoryAuthentication().withUser("Peeyoosh").password("123456").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * 1. Request first goes to Spring Security. If no user is logged in, then user will automatically be sent to login page.
		 * 2. if any user type http://localhost:8080/list-todos any url contains todo, will be secure through login page
		 * provided by spring security.
		 * 3. Role 'USER' is needed to access any todo functionality.
		 * 4. /login is exposed by Spring Security.
		 */
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*todo*/**")
				.access("hasRole('USER')").and().formLogin();
	}
}
