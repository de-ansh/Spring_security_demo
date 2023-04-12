package com.example.springsecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig   {

    //24:23
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser= User
                .withUsername("Pythonbot")
                .password("12345678")
                .roles("Role_normal")
                .build();
        UserDetails AdminUser = User
                .withUsername("Admin")
                .password("12345678")
                .roles("Role_admin")
                .build();
        UserDetails ActiveUser = User
                .withUsername("Active")
                .password("12345678")
                .roles("Role_active")
                .build();
        return new InMemoryUserDetailsManager(normalUser,ActiveUser,AdminUser);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().
                authorizeHttpRequests()
                .requestMatchers("/api/v1/docs/normal")
                .permitAll().anyRequest().authenticated().and().formLogin();
        return httpSecurity.build();
    }
}
