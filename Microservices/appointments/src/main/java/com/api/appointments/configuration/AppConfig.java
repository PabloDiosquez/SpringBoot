package com.api.appointments.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean(name = "apiConsume")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
