package com.store.productssv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductsSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsSvApplication.class, args);
	}

}
