package com.usecase.storeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.storeservice.model.StoreModel;
import com.usecase.storeservice.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

	public StoreModel addStore(StoreModel store) {

//		store.setCreatedBy();
		store.setCreatedOn(java.time.LocalDateTime.now());
		store.setUpdatedBy(store.getName());
		store.setUpdateOn(java.time.LocalDateTime.now());
		store.setActive(true);
		storeRepository.save(store);
		
		return store;
	}

	public List<StoreModel> getAllStores() {
		List<StoreModel> storeDetails = storeRepository.findAll();
		return storeDetails;
	}

	public StoreModel getStoreById(int id) {
		Optional<StoreModel> store = storeRepository.findById(id);
		StoreModel storeEntity = new StoreModel();
		BeanUtils.copyProperties(store.orElse(new StoreModel()), storeEntity);
		return storeEntity;
	}

	/*
	 * // public StoreModel updateStore(StoreModel store) { //// StoreModel
	 * storeEntity = new StoreModel(); //// BeanUtils.copyProperties(store,
	 * storeEntity); // storeRepository.save(store); // return store; // } //
	 * StoreModel storeEntity = new StoreModel(); // BeanUtils.copyProperties(store,
	 * storeEntity);
	 */
}
