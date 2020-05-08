package com.usecase.storeintegrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class StoreIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreIntegrationServiceApplication.class, args);

	}

}
