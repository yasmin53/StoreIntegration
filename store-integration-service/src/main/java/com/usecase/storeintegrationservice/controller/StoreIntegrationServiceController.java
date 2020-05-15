package com.usecase.storeintegrationservice.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.service.StoreIntegrationService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping(value="store-integration")
public class StoreIntegrationServiceController {

	@Autowired
	Environment envi;
	
	@Autowired
	StoreIntegrationService storeIntegrationService;
	
	@GetMapping(value="/getAllStores")
	public List<StoreIntegrationServiceEntity> getAllStores(){
		log.info("Getting all the store details ....");
		List<StoreIntegrationServiceEntity> storeDetails=new ArrayList<StoreIntegrationServiceEntity>();
		List<StoreIntegrationServiceEntity> storesList= storeIntegrationService.getAllStore();
		Stream<StoreIntegrationServiceEntity> stores=storesList.stream();
		Stream<StoreIntegrationServiceEntity> filterStoreList=stores.filter(stor->stor.getUpdateOn().equals(new Date()));
		filterStoreList.forEach(stor->{
			storeDetails.add(stor);
		});
		return storesList;
	}

	@GetMapping(value = "/getStoreById/{storeId}")
//	@HystrixCommand(fallbackMethod = "errorMessage")
	public ResponseEntity<?> getStoreDetailsById(@PathVariable("storeId") int storeId) {

		log.info("Store details of id : " + storeId + "is......");
		StoreIntegrationServiceEntity store = storeIntegrationService.getStoreById(storeId);
		
			log.info("Store details of id : " + storeId + "is......" + store);
			return new ResponseEntity<StoreIntegrationServiceEntity>(store, HttpStatus.OK);

		
//		return new ResponseEntity<String>("Validation Error", HttpStatus.NOT_ACCEPTABLE);
		}
	
	
	@GetMapping("/ribbon")
	public String testRibbon() {
		return envi.getProperty("local.server.port");
	}
	
}
