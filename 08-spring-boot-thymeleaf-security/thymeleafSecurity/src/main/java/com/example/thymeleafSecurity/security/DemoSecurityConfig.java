package com.example.thymeleafSecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // add support for jdbc

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailManager =  new JdbcUserDetailsManager(dataSource);
       
        userDetailManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        userDetailManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return userDetailManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> configurer
                                                    .requestMatchers("/").hasRole("EMPLOYEE")
                                                    .requestMatchers("/leaders/**").hasRole("MANAGER")
                                                    .requestMatchers("/systems/**").hasRole("ADMIN")
                                                    .anyRequest()
                                                    .authenticated()
                                    ).formLogin(form -> form.loginPage("/showMyLoginPage")
                                                                .loginProcessingUrl("/authenticateTheUser")
                                                                .permitAll())
                                                                .logout(logout -> logout.permitAll())
                                                                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")) ;
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    //     http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated())
    //         .formLogin(form -> form
    //                                 .loginPage("/showMyLoginPage")
    //                                 .loginProcessingUrl("/authenticateTheUser")
    //                                 .permitAll());

    //     return http.build();
    // }
    
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {

    //     UserDetails jon = User.builder()
    //         .username("jon")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE")
    //         .build();

    //     UserDetails mary = User.builder()
    //         .username("mary")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE","MANAGER")
    //         .build();

    //     UserDetails susan = User.builder()
    //         .username("susan")
    //         .password("{noop}test123")
    //         .roles("EMPLOYEE","MANAGER", "ADMIN")
    //         .build();

    //     return new InMemoryUserDetailsManager(jon, mary, susan);
        
    // }
}
