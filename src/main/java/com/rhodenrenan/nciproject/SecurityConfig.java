package com.rhodenrenan.nciproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	
	// Password Encoder	
	@Bean	
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	// Configuring HttpSecurity
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

      return http.build();
	}	
		
	// In-Memory Authentication
	@Bean
	public UserDetailsService userDetailsService(){
		
		// Admin
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		// Admin Assistant		
		UserDetails assistant = User.builder()
				.username("assistant")
				.password(passwordEncoder().encode("assistant"))
				.roles("ADMIN-ASTT")
				.build();
		
		// Supply Manager	
		UserDetails supply = User.builder()
				.username("supply")
				.password(passwordEncoder().encode("supply"))
				.roles("SUPPLY-MNGR")
				.build();
		
		return new InMemoryUserDetailsManager(admin, assistant, supply);
	}
}