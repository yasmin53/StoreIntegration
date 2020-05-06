package com.usecase.storeprocessservice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.storeprocessservice.model.StoreProcessModel;
import com.usecase.storeprocessservice.service.StoreProcessService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "store-process")
public class StoreProcessController {
	@Autowired
	StoreProcessService storeProcessService;

	@PostMapping(value = "/addjson")
	public void addJsonFile(@RequestBody StoreProcessModel store) {
		try {
			StoreProcessModel stores = storeProcessService.addStore(store);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("C:\\Users\\jagad\\OneDrive\\Desktop\\MiniProject\\sample.json"), stores);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@GetMapping(value = "/getAllStores")
	public ResponseEntity<?> findAll() {
		List<StoreProcessModel> storeList = storeProcessService.getAllStores();
		if (storeList.size() > 0) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				mapper.writeValue(new File("C:\\Users\\jagad\\OneDrive\\Desktop\\MiniProject\\sample1.json"), storeList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<List<StoreProcessModel>>(storeList, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Stores Not found", HttpStatus.NOT_FOUND);
		}
	}
}