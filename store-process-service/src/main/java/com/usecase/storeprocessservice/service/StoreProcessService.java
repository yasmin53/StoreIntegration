package com.usecase.storeprocessservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.storeprocessservice.model.StoreProcessModel;
import com.usecase.storeprocessservice.repository.StoreProcessRepository;

@Service
public class StoreProcessService {

	@Autowired
	StoreProcessRepository storeProcessRepository;

	public StoreProcessModel addStore(StoreProcessModel store) {

		storeProcessRepository.save(store);
		return store;
	}
	public List<StoreProcessModel> getAllStores() {
		List<StoreProcessModel> storeDetails = storeProcessRepository.findAll();
		return storeDetails;
	}
}
