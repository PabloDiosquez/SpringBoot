package com.meta.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean(name = "myFirstBean")
    @Qualifier(value = "firstBean")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My first bean!");
    }
    @Bean(name = "mySecondBean")
    @Qualifier(value = "secondBean")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My second bean!");
    }

}
