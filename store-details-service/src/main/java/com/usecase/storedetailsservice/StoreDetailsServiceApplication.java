package com.usecase.storedetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class StoreDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreDetailsServiceApplication.class, args);
	}

}
