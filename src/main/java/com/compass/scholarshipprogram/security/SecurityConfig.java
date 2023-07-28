package com.compass.scholarshipprogram.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/user/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/user/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/classes/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/classes/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/classes/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/classes/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/squad/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/squad/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/squad/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/squad/**").permitAll());

        // use HTTP Basic authentication
        // http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE
        // and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
