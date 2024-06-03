package com.meta.app;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyFirstClass {
    public String sayHi(){
        return "Hi! From my first class!";
    }
}
