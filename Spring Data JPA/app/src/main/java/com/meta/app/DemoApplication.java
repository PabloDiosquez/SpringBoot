package com.meta.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(DemoApplication.class, args);

		MyFirstClass myFirstClass = context.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHi());
	}
	//@Bean
	public MyFirstClass myFirstClass(){
		return new MyFirstClass();
	}
}
