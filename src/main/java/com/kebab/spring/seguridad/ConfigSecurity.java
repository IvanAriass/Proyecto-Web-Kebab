package com.kebab.spring.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	protected BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http 
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**")).permitAll()
					.requestMatchers(AntPathRequestMatcher.antMatcher("/css/**")).permitAll()
					.requestMatchers(AntPathRequestMatcher.antMatcher("/js/**")).permitAll()
					.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
					.requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
					.requestMatchers(AntPathRequestMatcher.antMatcher("/registro/**")).permitAll()
					.anyRequest().authenticated()
					)
			
			.formLogin(login -> login
					.loginPage("/login")
					.permitAll()
					.defaultSuccessUrl("/web", true)
					.loginProcessingUrl("/login-post")
					)
		
			.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")
					);
		
		http.csrf(csrf -> csrf.disable());
		http.headers(headers -> headers.frameOptions( frame -> frame.disable()));
		return http.build();
			
	}
}
