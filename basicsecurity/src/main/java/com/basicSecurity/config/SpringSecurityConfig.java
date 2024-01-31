package com.basicSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf ->csrf.disable())
                .authorizeRequests(authorize -> {
                            authorize
                                    .requestMatchers("/user/save").permitAll() // Allow access to "/user/save"
                                    .anyRequest().authenticated();
                        } // Require authentication for any other request
                )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }


//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests((authorize) ->{authorize.anyRequest()
//                        .authenticated();
//                }).httpBasic(Customizer.withDefaults());
//
//        return httpSecurity.build();
//
//    }
}
