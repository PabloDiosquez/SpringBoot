package com.meta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(DemoApplication.class, args);

		MyFirstService myFirstService = context.getBean(MyFirstService.class);
		System.out.println("Story = " + myFirstService.tellAStory());
    }
}
