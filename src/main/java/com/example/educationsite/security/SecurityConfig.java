package com.example.educationsite.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //password hashing
    }
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/signup", "/login", "/public/**").permitAll()
                            .requestMatchers(HttpMethod.GET).permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin(formLogin ->
                            formLogin
                                    .loginPage("/login")
                                    .permitAll()
                    )
                    .httpBasic(withDefaults())
                    .csrf(csrf -> csrf.disable());

            return http.build();
        }
        /*
        @Bean
        public UserDetailsService users(PasswordEncoder passwordEncoder) {


            UserDetails user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("root"))
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(user);
        }
      */
        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(customUserDetailsService);
            authProvider.setPasswordEncoder(passwordEncoder());
            return authProvider;
        }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
        return authenticationManagerBuilder.build();
    }
}

