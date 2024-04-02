package com.lpt.contactsspringsecurity.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@AllArgsConstructor
@Configuration
public class SecurityConfig {

        private BCryptPasswordEncoder bCryptPasswordEncoder;
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.
                    authorizeRequests().
                    anyRequest().authenticated().
                    and().
                    httpBasic();

            return http.build();
        }
        @Bean
        public UserDetailsService users(){
            UserDetails admin = User.builder()
                    .username("admin")
                    .password(bCryptPasswordEncoder.encode("admin-pass"))
                    .roles("ADMIN")
                    .build();

            UserDetails user = User.builder()
                    .username("user")
                    .password(bCryptPasswordEncoder.encode("user-pass"))
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(admin);
        }


}
