package com.usecase.storeprocessservice.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("store-details-service")
@RibbonClient("store-details-service")
public interface StoreServiceProxy {
	@GetMapping(value = "/customer")
	public ResponseEntity<?>getAllCustomers();
	
	@GetMapping("/ribbon")
	public String testRibbon();
}
