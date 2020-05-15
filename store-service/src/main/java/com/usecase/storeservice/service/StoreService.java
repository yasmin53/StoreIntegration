package com.usecase.storeservice.service;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.storeservice.entity.StoreEntity;
import com.usecase.storeservice.model.StoreModel;
import com.usecase.storeservice.repository.StoreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

	public StoreEntity addStore(StoreEntity store) {

		store.setCreatedBy(store.getName());
		store.setCreatedOn(new Date());
		store.setUpdatedBy(store.getName());
		store.setUpdateOn(new Date());
		store.setActive(true);
		storeRepository.save(store);
		
		return store;
	}
	

	public List<StoreEntity> getAllStores() {
		List<StoreEntity> storeDetails = storeRepository.findAll();
		return storeDetails;
	}

	public StoreEntity getStoreById(int id) {
		StoreEntity store = storeRepository.findByStoreId(id);
		StoreEntity storeEntity = new StoreEntity();
		BeanUtils.copyProperties(store, storeEntity);
		return storeEntity;
	}

	public StoreEntity updateStore(StoreEntity storeModel) {
		log.info(storeModel.getName());
		Optional<StoreEntity> storeDetails = storeRepository.findById(storeModel.getId());
		StoreEntity storeEntity = storeDetails.get();
		log.info(storeEntity.getName());
		storeEntity.setName(storeModel.getName());
		storeEntity.setStoreId(storeModel.getStoreId());
		storeEntity.setName(storeModel.getName());
		storeEntity.setAddressline1(storeModel.getAddressline1());
		storeEntity.setAddressline2(storeModel.getAddressline2());
		storeEntity.setCity(storeModel.getCity());
		storeEntity.setState(storeModel.getState());
		storeEntity.setCountry(storeModel.getCountry());
		storeEntity.setPincode(storeModel.getPincode());
		storeEntity.setContact(storeModel.getContact());
		storeEntity.setHolidayOn(storeModel.getHolidayOn());
		storeEntity.setOpenCloseTimings(storeModel.getOpenCloseTimings());
		storeEntity.setCreatedOn(storeModel.getCreatedOn());
		storeEntity.setCreatedBy(storeModel.getCreatedBy());
		storeEntity.setUpdateOn(new Date());
		storeEntity.setUpdatedBy(storeModel.getName());
		storeEntity.setActive(storeModel.isActive());
		
		
    	
		
		storeRepository.save(storeEntity);
		return storeEntity;
	}
}
