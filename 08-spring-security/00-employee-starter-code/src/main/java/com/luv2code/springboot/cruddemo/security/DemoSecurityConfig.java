package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
    
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager(){
    //     UserDetails john = User.builder()
    //         .username("john")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE")
    //         .build();
        
    //     UserDetails mary = User.builder()
    //     .username("mary")
    //     .password("{noop}test123")
    //     .roles("EMPLOYEE, MANAGER")
    //     .build();

    //     UserDetails susan = User.builder()
    //     .username("susaan")
    //     .password("{noop}test123")
    //     .roles("EMPLOYEE,MANAGER,ADMIN")
    //     .build();

    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);

        // Query per tabelle custom

        // userDetailsManager.setUsersByUsernameQuery(
        //     "SELECT username, password, enabled FROM users WHERE username = ?"
        // );
        // userDetailsManager.setAuthoritiesByUsernameQuery(
        //     "SELECT username, authority FROM authorities WHERE username = ?"
        // );

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> 
            configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAnyRole("ADMIN")
        );

        // use HTTP base auth
        http.httpBasic(Customizer.withDefaults());
        // disable CSRF
        http.csrf(csrf -> csrf.disable());
        return null;
    }
}
