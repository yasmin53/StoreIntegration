package com.usecase.storedetailsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.storedetailsservice.integrationentity.StoreIntegrationEntity;
import com.usecase.storedetailsservice.integrationproxy.StoreIntegrationProxy;

@RestController
@RequestMapping(value="store-details")
public class StoreDetailsController {

	@Autowired
	StoreIntegrationProxy integrationProxy;
	
	@GetMapping(value = "/getAllStores")
	public List<StoreIntegrationEntity> getAllStores() {
		List<StoreIntegrationEntity> storelist = integrationProxy.getAllStores();
		return storelist;
	}
	@GetMapping(value = "/getStoreById/{storeId}")
	public ResponseEntity<?> getStoreById(@PathVariable("storeId") int id) {
		ResponseEntity<?> store= integrationProxy.getStoreById(id);
		return store;
	}
	
	
	@GetMapping("/ribbon")
	public String testRibbon() {
		String test = integrationProxy.testRibbon();
		return test;
	}
}
