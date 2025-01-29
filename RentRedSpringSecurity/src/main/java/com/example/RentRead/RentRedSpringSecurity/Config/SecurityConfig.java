package com.example.RentRead.RentRedSpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
//import static org.springframework.boot.convert.ApplicationConversionService.configure;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.RentRead.RentRedSpringSecurity.Service.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true)
public class SecurityConfig {

    @Autowired
    UserService userService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.authorizeHttpRequests(configure -> configure.requestMatchers("users/login", "users/register").permitAll()
                .requestMatchers("/book/").hasRole("ADMIN").anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    private AuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider authentication=new DaoAuthenticationProvider();
        authentication.setUserDetailsService(userService);
        authentication.setPasswordEncoder(passwordEncoder());
        return authentication;

    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
        
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
