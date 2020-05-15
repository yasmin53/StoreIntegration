package com.usecase.storeservice;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.cloud.config.server.EnableConfigServer;

import com.usecase.storeservice.typesafe.StoreServiceConfigurationPropertoes;


@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableConfigServer
@EnableConfigurationProperties(StoreServiceConfigurationPropertoes.class)
//@EnableWebSecurity
public class StoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceApplication.class, args);
		}

}
