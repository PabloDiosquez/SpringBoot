package com.meta.app.demo;

public class MyFirstClass {
    private final String message;

    public MyFirstClass(String message) {
        this.message = message;
    }

    public String sayHi(){
        return "Hi! From my first class! ==> Message: " + message;
    }
}
