package com.example.postssv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PostsSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostsSvApplication.class, args);
	}

}
