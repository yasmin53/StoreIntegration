package com.usecase.storeprocessservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.storeprocessservice.entity.StoreProcessEntity;
import com.usecase.storeprocessservice.model.StoreProcessModel;
import com.usecase.storeprocessservice.repository.StoreProcessRepository;

@Service
public class StoreProcessService {

	@Autowired
	StoreProcessRepository storeProcessRepository;

	public StoreProcessModel addStore(StoreProcessModel store) {

		store.setCreatedBy(store.getName());
		store.setCreatedOn(new Date());
		store.setUpdatedBy(store.getName());
		store.setUpdateOn(new Date());
		store.setActive(true);
		storeProcessRepository.save(store);
		
		return store;
	}
	public List<StoreProcessModel> getAllStores() {
		List<StoreProcessModel> storeDetails = storeProcessRepository.findAll();
		return storeDetails;
	}
}
