package com.lpt.contactsspringsecurity.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .dispatcherTypeMatchers(HttpMethod.GET).permitAll()
                    .dispatcherTypeMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                    .dispatcherTypeMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic().and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // No crear sesiones HTTP

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

            return new InMemoryUserDetailsManager(admin, user);
        }


}
