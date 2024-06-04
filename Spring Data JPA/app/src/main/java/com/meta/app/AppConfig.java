package com.meta.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Configuration
public class AppConfig {
    @Bean(name = "myFirstBean")
    //@Qualifier(value = "firstBean")
    //@Primary
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My first bean!");
    }
    @Bean(name = "mySecondBean")
    //@Qualifier(value = "secondBean")
    @Profile("dev") // only available for 'dev-profile'
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My second bean!");
    }

}
