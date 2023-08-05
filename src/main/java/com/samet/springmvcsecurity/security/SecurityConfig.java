package com.samet.springmvcsecurity.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails samet= User.builder()
                .username("samet")
                .password("{noop}samet123")
                .roles("STUDENT")
                .build();

        UserDetails canan=User.builder()
                .username("canan")
                .password("{noop}canan123")
                .roles("STUDENT","TEACHER")
                .build();



        UserDetails murat=User.builder()
                .username("murat")
                .password("{noop}murat123")
                .roles("STUDENT","TEACHER","ADMIN")
                .build();


        return  new InMemoryUserDetailsManager(samet,canan,murat);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(configurer->
                    configurer.requestMatchers("/").permitAll()
                            .requestMatchers("/teachers/**").hasRole("TEACHER")
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
        ).formLogin(customizer->
                customizer.loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()

                        ). logout(logout-> logout.permitAll())
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/denied")
                        )
        ;
        return httpSecurity.build();
    }
}
