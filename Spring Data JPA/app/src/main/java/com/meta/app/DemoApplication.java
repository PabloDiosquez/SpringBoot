package com.meta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(DemoApplication.class, args);

		MyFirstService myFirstService = context.getBean(MyFirstService.class);
		System.out.println("Story = " + myFirstService.tellAStory());
		System.out.println("Java version = " + myFirstService.getJavaVersion());
		System.out.println("OS = " + myFirstService.getOS());
		System.out.println("My custom property = " + myFirstService.readProp());
		System.out.println("My custom prop = " + myFirstService.getCustomProp());
		System.out.println("My custom prop bis= " + myFirstService.getCustomPropBis());
    }
}
