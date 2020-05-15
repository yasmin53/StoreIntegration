package com.usecase.storeservice.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.usecase.storeservice.StoreServiceApplication;
import com.usecase.storeservice.controller.StoreController;
import com.usecase.storeservice.entity.StoreEntity;
import com.usecase.storeservice.service.StoreService;

@SpringBootTest(classes = StoreServiceApplication.class)
class StoreServiceControllerTests {

	@Mock
	private StoreService storeService;
	
	@InjectMocks
	private StoreController storeController;
	

	@Test
	public void getAllStoresTest() {
		List<StoreEntity> storelist = storeService.getAllStores();
	when(storeService.getAllStores()).thenReturn(storelist);
		ResponseEntity<?> storeEntity =   storeController.getStoreDetailsById(102);
		verify(storeService, times(1)).getAllStores();
	}
	@Test
	 public void getAllStoresTestForException() {
		 
		 Exception exception = assertThrows(NullPointerException.class, () ->{
			 when(storeService.getAllStores()).thenThrow(NullPointerException.class);
			 storeController.getAllStores();});
		 
		   assertNotNull(exception);
		   verify(storeService, times(1)).getAllStores();
		   
		 }

}
