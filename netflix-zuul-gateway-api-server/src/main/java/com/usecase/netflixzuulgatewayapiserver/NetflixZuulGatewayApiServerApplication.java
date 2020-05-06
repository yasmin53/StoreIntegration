package com.usecase.netflixzuulgatewayapiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableDiscoveryClient
@EnableZuulProxy
@EnableWebSecurity
@SpringBootApplication
public class NetflixZuulGatewayApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulGatewayApiServerApplication.class, args);
	}

}
