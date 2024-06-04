package com.meta.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
@Service
public class MyFirstService {
    //@Autowired
    //@Qualifier("mySecondBean")
    private MyFirstClass myFirstClass;
    private Environment environment;

    /*
     public MyFirstService(@Qualifier("secondBean") MyFirstClass myFirstClass) {
         this.myFirstClass = myFirstClass;
     }
    */
    @Autowired
    public void setMyFirstClass(@Qualifier("mySecondBean") MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }
    @Autowired
    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

    public String tellAStory(){
        return "The dependency is saying: \n" + myFirstClass.sayHi();
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }

    public String getOS(){
        return environment.getProperty("os.name");
    }

    public String readProp(){
        return environment.getProperty("my.custom.property");
    }
}
