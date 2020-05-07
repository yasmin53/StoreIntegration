package com.usecase.storeservice.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.usecase.storeservice.model.StoreModel;
import com.usecase.storeservice.repository.StoreRepository;
import com.usecase.storeservice.service.StoreService;
import com.usecase.storeservice.validators.StoreValidations;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("store-details")
public class StoreController {

	@Autowired
	StoreService storeService;
	@Autowired
	StoreValidations storeValidator;

	@PostMapping(value = "/addStore")
	public StoreModel save(@RequestBody StoreModel store) {

		log.info("adding store details........");
		if (storeValidator.validate(store) == true) {
			StoreModel stores = storeService.addStore(store);
			log.info("added store details successfully --> {}", stores);
			return stores;
		}
		return null;
	}

	@GetMapping(value = "/getAllStores")
	public ResponseEntity<?> findAll() {
		List<StoreModel> storeList = storeService.getAllStores();
		if (storeList.size() > 0) {
			log.info("The Store Details are");
			return new ResponseEntity<List<StoreModel>>(storeList, HttpStatus.OK);
		} else {
			log.info("There is no data to retriew");
			return new ResponseEntity<String>("Stores Not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/getStoreById/{id}")
	public StoreModel findOne(@PathVariable int id) {
		try {
			log.info("Store details of id : " + id + "is......");
			StoreModel store = storeService.getStoreById(id);
			return store;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @PutMapping(value = "/store") public StoreModel updateStore(@RequestBody
	 * StoreModel store) { StoreModel stores = storeService.updateStore(store);
	 * return stores; }
	 */

}
