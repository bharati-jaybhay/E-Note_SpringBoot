//package com.web.e_note.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SpringSecurityConfig {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF protection if not needed
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/register/**").permitAll() // Publicly accessible
//                        .requestMatchers("/index").permitAll()       // Publicly accessible
//                        .requestMatchers("/users").hasRole("ADMIN") // Admin-only access
//                        .anyRequest().authenticated()               // All other requests need authentication
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")                          // Custom login page
//                        .usernameParameter("username")                  // Use "email" as the username parameter
//                        .loginProcessingUrl("/authenticate")         // URL to submit login credentials
//                        .defaultSuccessUrl("/note")                 // Redirect after successful login
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Logout URL
//                        .logoutSuccessUrl("/login?logout")                           // Redirect after logout
//                        .permitAll()
//                );
//
//        return http.build();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//}
