package com.compass.scholarshipprogram.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails student = User.builder()
                .username("student")
                .password("{noop}compass123")
                .roles("student")
                .build();

        UserDetails coordinator = User.builder()
                .username("coordinator")
                .password("{noop}compass123")
                .roles("student", "coordinator")
                .build();

        UserDetails master = User.builder()
                .username("master")
                .password("{noop}compass123")
                .roles("student", "coordinator", "master")
                .build();

        return new InMemoryUserDetailsManager(student, coordinator, master);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/user/all").hasRole("student")
                .requestMatchers(HttpMethod.POST, "/user/save").hasRole("coordinator")
                .requestMatchers(HttpMethod.PUT, "/user/edit/{id}").hasRole("coordinator")
                .requestMatchers(HttpMethod.DELETE, "/user/delete/{id}").hasRole("master")
                .requestMatchers(HttpMethod.GET, "/classes/all").hasRole("student")
                .requestMatchers(HttpMethod.POST, "/classes/save").hasRole("coordinator")
                .requestMatchers(HttpMethod.PUT, "/classes/edit/{id}").hasRole("coordinator")
                .requestMatchers(HttpMethod.DELETE, "/classes/delete/{id}").hasRole("master")
                .requestMatchers(HttpMethod.GET, "/squad/all").hasRole("student")
                .requestMatchers(HttpMethod.POST, "/squad/save/{classesId}").hasRole("coordinator")
                .requestMatchers(HttpMethod.PUT, "/squad/edit/{id}").hasRole("coordinator")
                .requestMatchers(HttpMethod.DELETE, "/squad/delete/{id}").hasRole("master"));

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE
        // and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
