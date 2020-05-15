package com.usecase.storedetailsservice.integrationproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.usecase.storedetailsservice.integrationentity.StoreIntegrationEntity;
	@FeignClient("store-integration-service")
	@RibbonClient("store-integration-service")
	public interface StoreIntegrationProxy {
		
		@GetMapping(value="store-integration/getAllStores")
		public List<StoreIntegrationEntity> getAllStores();
		
		@GetMapping(value="store-integration/getStoreById/{storeId}")
		public ResponseEntity<?>  getStoreById(@PathVariable("storeId") int id);
			
		@GetMapping("store-integration/ribbon")
		public String testRibbon();
	}

