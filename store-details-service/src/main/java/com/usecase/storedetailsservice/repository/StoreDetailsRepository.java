package com.usecase.storedetailsservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.storedetailsservice.model.StoreDetailsModel;

public interface StoreDetailsRepository extends JpaRepository<StoreDetailsModel, Integer>{

	
	
}
