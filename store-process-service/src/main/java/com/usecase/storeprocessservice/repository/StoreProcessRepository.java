package com.usecase.storeprocessservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.storeprocessservice.model.StoreProcessModel;

public interface StoreProcessRepository extends JpaRepository<StoreProcessModel, Integer> {

}
