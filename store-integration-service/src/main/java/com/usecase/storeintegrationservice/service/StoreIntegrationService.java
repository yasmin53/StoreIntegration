package com.usecase.storeintegrationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.model.StoreIntegrationServiceModel;
import com.usecase.storeintegrationservice.repository.StoreIntegrationRepository;

@Service
public class StoreIntegrationService {

	@Autowired
	StoreIntegrationRepository storeIntegrationRepository;
	public StoreIntegrationServiceEntity save(StoreIntegrationServiceModel store) {
		StoreIntegrationServiceEntity storeIntegrationEntity= new StoreIntegrationServiceEntity();
//		storeIntegrationEntity.setId(store.getId());
		storeIntegrationEntity.setStoreId(store.getStoreId());
		storeIntegrationEntity.setName(store.getName());
		storeIntegrationEntity.setAddressline1(store.getAddressline1());
		storeIntegrationEntity.setAddressline2(store.getAddressline2());
		storeIntegrationEntity.setCity(store.getCity());
		storeIntegrationEntity.setState(store.getState());
		storeIntegrationEntity.setCountry(store.getCountry());
		storeIntegrationEntity.setPincode(store.getPincode());
		storeIntegrationEntity.setContact(store.getContact());
		storeIntegrationEntity.setHolidayOn(store.getHolidayOn());
		storeIntegrationEntity.setOpenCloseTimings(store.getOpenCloseTimings());
		storeIntegrationEntity.setCreatedOn(store.getCreatedOn());
		storeIntegrationEntity.setCreatedBy(store.getCreatedBy());
		storeIntegrationEntity.setUpdateOn(store.getUpdateOn());
		storeIntegrationEntity.setUpdatedBy(store.getUpdatedBy());
		storeIntegrationEntity.setActive(store.isActive());
		
		return  storeIntegrationRepository.save(storeIntegrationEntity);
	}
	
//	public Iterable<StoreIntegrationServiceModel> saveAll(List<StoreIntegrationServiceModel> storeJsonList){
//	
//		StoreIntegrationEntity store= new StoreIntegrationEntity();
//		
//		return storeIntegrationRepository.saveAll(storeJsonList);
//	}
//	
	public Iterable<StoreIntegrationServiceEntity> getAllStore(){
		
		return storeIntegrationRepository.findAll();
	}
}
