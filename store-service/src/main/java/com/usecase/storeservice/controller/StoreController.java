package com.usecase.storeservice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.usecase.storeservice.entity.StoreEntity;
import com.usecase.storeservice.model.StoreModel;
import com.usecase.storeservice.repository.StoreRepository;
import com.usecase.storeservice.service.StoreService;
import com.usecase.storeservice.typesafe.StoreServiceConfigurationPropertoes;
import com.usecase.storeservice.validators.StoreValidations;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@EnableHystrix
@RequestMapping("store-details")
public class StoreController {

	@Autowired
	StoreService storeService;
	@Autowired
	StoreValidations storeValidator;

	@Autowired
	StoreServiceConfigurationPropertoes properties;
	
//	@Value("${my.path: default value}") 
//	String  path;
	
	@PostMapping(value = "/addStore")
	public StoreEntity addJsonFile(@RequestBody StoreEntity store) {
		StoreEntity stores = storeService.addStore(store);
		String path= properties.getPath();

		try {
			ObjectMapper mapper = new ObjectMapper();
//			String  path="C:\\Users\\jagad\\OneDrive\\Desktop\\MiniProject\\Json";
			int id = store.getStoreId();
			log.info("Storing the data into json file....");
			mapper.writeValue(new File(path +"\\"+ id + ".json"),
					stores);
			log.info("Stored the store details in files ... ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stores;

	}

	@GetMapping(value = "/getAllStores")
	public ResponseEntity<?> getAllStores() {
		List<StoreEntity> storeList = storeService.getAllStores();
		if (storeList.size() > 0) {
			log.info("The Store Details are");
			return new ResponseEntity<List<StoreEntity>>(storeList, HttpStatus.OK);
		} else {
			log.info("There is no data to retriew");
			return new ResponseEntity<String>("Stores Not found", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value = "/getStoreById/{storeId}")
	@HystrixCommand(fallbackMethod = "errorMessage")
	public ResponseEntity<?> getStoreDetailsById(@PathVariable("storeId") int storeId) {

		log.info("Store details of id : " + storeId + "is......");
		StoreEntity store = storeService.getStoreById(storeId);
		boolean valid = storeValidator.validate(store);
		if (valid) {
			log.info("Store details of id : " + storeId + "is......" + store);
			return new ResponseEntity<StoreEntity>(store, HttpStatus.OK);

		}
		return new ResponseEntity<String>("Validation Error", HttpStatus.NOT_ACCEPTABLE);
		}
//		@GetMapping(value = "/getStoreById/{storeId}")
//		@HystrixCommand(fallbackMethod = "errorMessage")
//		public StoreEntity getStoreDetailsById(@PathVariable("storeId") int storeId) {
//			return storeService.getStoreById(storeId);
//			
//		}

	

	public ResponseEntity<?> errorMessage(@PathVariable("storeId") int storeId) {
		log.info("No Data");
		return new ResponseEntity<String>("no Store detail with id " + storeId, HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/updatestore")
	public StoreEntity updateStore(@RequestBody StoreEntity store) {
		StoreEntity stores = storeService.updateStore(store);
		return stores;
	}

}
