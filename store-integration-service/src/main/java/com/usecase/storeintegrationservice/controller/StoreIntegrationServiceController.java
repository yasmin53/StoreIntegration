package com.usecase.storeintegrationservice.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.model.StoreIntegrationServiceModel;
import com.usecase.storeintegrationservice.service.StoreIntegrationService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping(value="store-integration")
public class StoreIntegrationServiceController {

	@Autowired
	StoreIntegrationService storeIntegrationService;
	
	
	@GetMapping(value="/getAllStores")
	public Iterable<StoreIntegrationServiceEntity> getAllStores(){
		return storeIntegrationService.getAllStore();
	}
	
	
	
}
