package com.usecase.storedetailsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.storedetailsservice.model.StoreDetailsModel;
import com.usecase.storedetailsservice.service.StoreDetailsService;

@RestController
public class StoreDetailsController {

	@Autowired
	Environment environment;
	
	@Autowired
	StoreDetailsService storeDetailsService ;
	
	@GetMapping(value = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?>getAllCustomers(){
		List<StoreDetailsModel> customersList= storeDetailsService.getAllCustomers();
		if(customersList.size()>0) {
			return new ResponseEntity<List>(customersList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No data",HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/ribbon")
	public String testRibbon() {
		return environment.getProperty("local.server.port");
	}
	
}
