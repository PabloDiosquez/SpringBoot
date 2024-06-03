package com.meta.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "myFirstBean")
    public MyFirstClass myFirstClass(){
        return new MyFirstClass("My first bean!");
    }

}
