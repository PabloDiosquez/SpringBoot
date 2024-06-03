package com.meta.app;


import org.springframework.stereotype.Service;
@Service
public class MyFirstService {
    private final MyFirstClass myFirstClass;

    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The dependency is saying: \n" + myFirstClass.sayHi();
    }
}
