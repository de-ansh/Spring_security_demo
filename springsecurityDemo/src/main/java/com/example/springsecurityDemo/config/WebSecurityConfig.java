package com.example.springsecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class WebSecurityConfig   {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //25:38
    @Bean
    public UserDetailsService userDetailsService(){
       /* UserDetails normalUser= User
                .withUsername("Pythonbot")
                .password(passwordEncoder().encode("12345678"))
                .roles("Normal")
                .build();
        UserDetails AdminUser = User
                .withUsername("admin")
                .password(passwordEncoder().encode("12345678"))
                .roles("Admin")
                .build();
        UserDetails ActiveUser = User
                .withUsername("Active")
                .password(passwordEncoder().encode("12345678"))
                .roles("Active")
                .build();
        return new InMemoryUserDetailsManager(normalUser,ActiveUser,AdminUser);*/
        return  new CustomUserDetailsService();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().
                authorizeHttpRequests()
              //  .requestMatchers("/api/v1/docs/admin").
              //  hasRole("Admin")
                //.requestMatchers("/api/v1/docs/active").hasRole("Active")
               // .requestMatchers("/api/v1/docs/normal")
             //   .permitAll()
                .anyRequest().authenticated().and().formLogin();
        return httpSecurity.build();
    }
}
