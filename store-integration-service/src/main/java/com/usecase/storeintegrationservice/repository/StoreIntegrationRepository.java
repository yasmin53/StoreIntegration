package com.usecase.storeintegrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.usecase.storeintegrationservice.entity.StoreIntegrationServiceEntity;
import com.usecase.storeintegrationservice.model.StoreIntegrationServiceModel;

public interface StoreIntegrationRepository extends CrudRepository<StoreIntegrationServiceEntity, Integer>{

//	Iterable<StoreIntegrationServiceModel> save(StoreIntegrationServiceModel storeIntegrationEntity);

}
