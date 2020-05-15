package com.usecase.storeintegrationservice.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.model.StoreIntegrationServiceModel;
import com.usecase.storeintegrationservice.service.StoreIntegrationService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StoreScheduler {
	@Autowired
	StoreIntegrationService storeIntegrationService;

	@Scheduled(fixedRate = 200000)
	public void stroingStoreDetails() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			File inputfile = new File("C:\\Users\\jagad\\\\OneDrive\\Desktop\\MiniProject\\Json");
			File[] jsonfiles = inputfile.listFiles();
			if (jsonfiles.length > 0) {
				for(File jsonfile:jsonfiles) {
					InputStream inputStream = new FileInputStream(jsonfile);
					TypeReference<List<StoreIntegrationServiceEntity>> typeReference = new TypeReference<List<StoreIntegrationServiceEntity>>() {
					};
					List<StoreIntegrationServiceEntity> stores = mapper.readValue(inputStream, typeReference);
					storeIntegrationService.saveAll(stores);
					log.info("Storing the store detains in database..... !!!");
					jsonfile.delete();
					
				}
			} else {
				log.info("Files are Stored....");
			}
		} catch (JsonParseException e) {
			log.info("Getting an exception");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.info("Getting an exception");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			log.info("Getting an exception");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Getting an exception");
			e.printStackTrace();
		}
	}
}
