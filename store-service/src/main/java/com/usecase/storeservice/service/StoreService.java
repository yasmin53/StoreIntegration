package com.usecase.storeservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.storeservice.model.StoreModel;
import com.usecase.storeservice.repository.StoreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

	public StoreModel addStore(StoreModel store) {
		store.setCreatedBy(store.getName());
		store.setCreatedOn(java.time.LocalDateTime.now());
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

//	public StoreModel updateStore(StoreModel storeModel) {
//		log.info(storeModel.getName());
//		Optional<StoreModel> storeDetails = storeRepository.findById(storeModel.getId());
//		StoreModel storeEntity = storeDetails.get();
//		log.info(storeEntity.getName());
//		storeEntity.setName(storeModel.getName());
//		
//    	storeEntity.setUpdateOn(java.time.LocalDateTime.now());
//		storeEntity.setUpdatedBy(storeModel.getName());
//		storeEntity.setActive(true);
//		storeRepository.save(storeEntity);
//		return storeEntity;
//	}
}
