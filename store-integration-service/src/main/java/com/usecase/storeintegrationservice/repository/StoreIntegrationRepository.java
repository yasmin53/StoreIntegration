package com.usecase.storeintegrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.storeintegrationservice.model.StoreIntegrationModel;

public interface StoreIntegrationRepository extends JpaRepository<StoreIntegrationModel, Integer>{

}
