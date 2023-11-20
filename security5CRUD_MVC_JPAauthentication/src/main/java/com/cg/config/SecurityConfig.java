package com.cg.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {	

	@Resource
	private UserDetailsService userDetailsService;

	//AuthenticationProvider implementation that retrieves user details from a UserDetailsService.
	@Bean
	public DaoAuthenticationProvider authProvider(PasswordEncoder encoder) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder);
		return authProvider;
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		    .antMatchers("/create").hasRole("ADMIN")
		    .antMatchers(HttpMethod.GET, "/getById/*").hasAnyRole("USER","ADMIN")
		    .antMatchers(HttpMethod.GET, "/getAll").authenticated()
		    .anyRequest().permitAll()
		    
			.and()
			.csrf().disable()
			.formLogin()
			.defaultSuccessUrl("/home")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		return http.build();

	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
