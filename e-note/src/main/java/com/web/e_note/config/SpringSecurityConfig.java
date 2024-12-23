//package com.web.e_note.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import lombok.AllArgsConstructor;
//
//@Configuration
//@EnableMethodSecurity
//@AllArgsConstructor
//public class SpringSecurityConfig {
//
//	private UserDetailsService userDetailsService;
//
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//
//		httpSecurity.csrf((csrf)->csrf.disable())
//		.authorizeHttpRequests((authorize)->{
////			authorize.requestMatchers(HttpMethod.POST,"/**").hasRole("ROLE_ADMIN");
//			authorize.anyRequest().authenticated();})
//		.httpBasic(Customizer.withDefaults());
//
//		return httpSecurity.build();
//	}
//
//
//	@Bean
//	public static PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
//
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}
//
//
//
//
//
//
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		UserDetails manvi = User.builder()
//				.username("manvi")
//				.password(passwordEncoder().encode("1234"))
//				.roles("USER")
//				.build();
//
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(manvi, admin);
//	}
//}