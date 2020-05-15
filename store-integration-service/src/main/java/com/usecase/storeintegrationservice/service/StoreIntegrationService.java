package com.usecase.storeintegrationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.model.StoreIntegrationServiceModel;
import com.usecase.storeintegrationservice.repository.StoreIntegrationRepository;

@Service
public class StoreIntegrationService {

	@Autowired
	StoreIntegrationRepository storeIntegrationRepository;
	public StoreIntegrationServiceEntity save(StoreIntegrationServiceEntity  store) {

		
		return  storeIntegrationRepository.save(store);
	}
	
	public Iterable<StoreIntegrationServiceEntity> saveAll(List<StoreIntegrationServiceEntity> storeJsonList){
	
		StoreIntegrationServiceEntity store= new StoreIntegrationServiceEntity();
		
		return storeIntegrationRepository.saveAll(storeJsonList);
	}
	
	public List<StoreIntegrationServiceEntity> getAllStore(){
		
		return storeIntegrationRepository.findAll();
	}
	public StoreIntegrationServiceEntity getStoreById(int storeId) {
		StoreIntegrationServiceEntity store=storeIntegrationRepository.findByStoreId(storeId);
		return store;
	}
}
