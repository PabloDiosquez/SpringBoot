package com.meta.app.demo;



import com.meta.app.demo.MyFirstClass;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
@Service
@Getter
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-bis.properties")
})
public class MyFirstService {
    //@Autowired
    //@Qualifier("mySecondBean")
    private MyFirstClass myFirstClass;
    private Environment environment;

    @Value("${my.custom.property}")
    private String propValue;

    @Value("my.property")
    private String customProp;

    @Value("my.property.bis")
    private String customPropBis;

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
