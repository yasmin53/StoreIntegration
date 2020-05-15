package com.usecase.storeintegrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.model.StoreIntegrationServiceModel;

public interface StoreIntegrationRepository extends JpaRepository<StoreIntegrationServiceEntity, Integer>{

public StoreIntegrationServiceEntity findByStoreId(int storeId);
}
