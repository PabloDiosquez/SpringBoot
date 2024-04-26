package com.example.hotelssv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelsSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsSvApplication.class, args);
	}

}
