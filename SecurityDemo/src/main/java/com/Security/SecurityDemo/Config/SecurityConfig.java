package com.Security.SecurityDemo.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Security.SecurityDemo.security.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JwtFilter jwtfilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->
				auth
				.requestMatchers(HttpMethod.POST,"/home/user").permitAll()
				.requestMatchers("/home").authenticated()
				.anyRequest().permitAll()
		)
		//.formLogin(form->form.permitAll().defaultSuccessUrl("/welcome", true))
		.csrf(csrf->csrf.disable())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class)
		;
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetail() {
//		UserDetails alice=User.withUsername("alice")
//				.password(passwordEncoder.encode("user123"))
//				.roles("user")
//				.build();
//		UserDetails john=User.withUsername("john")
//				.password(passwordEncoder.encode("john123"))
//				.roles("admin")
//				.build();
//		UserDetails jailer=User.withUsername("jailer")
//				.password(passwordEncoder.encode("jailer123"))
//				.roles("jailer")
//				.build();
		return new CustomUserDetailService();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(List.of(authenticationProvider()));
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetail());
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
