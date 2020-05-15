package com.usecase.storeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.storeservice.entity.StoreEntity;
import com.usecase.storeservice.model.StoreModel;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer>{
	public StoreEntity findByStoreId(int storeId);

}
