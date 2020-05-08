package com.usecase.storeprocessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class StoreProcessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProcessServiceApplication.class, args);
	}

}
