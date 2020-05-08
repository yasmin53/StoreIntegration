package com.usecase.storedetailsservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.usecase.storedetailsservice.model.StoreDetailsModel;
/*import com.usecase.storedetailsservice.repository.ArrayList;
import com.usecase.storedetailsservice.repository.CustomerPreferenceEntity;
import com.usecase.storedetailsservice.repository.List;*/
import com.usecase.storedetailsservice.repository.StoreDetailsRepository;

@Service
public class StoreDetailsService {

	@Autowired
	StoreDetailsRepository customerPreferenceRepo;
	
	public List<StoreDetailsModel> getAllCustomers() {
		List<StoreDetailsModel> entities=customerPreferenceRepo.findAll();
		List<StoreDetailsModel> allCustomersList=new ArrayList<StoreDetailsModel>();
		for(StoreDetailsModel entity:entities) {
			StoreDetailsModel customerPreferenceEntity=new StoreDetailsModel();
			BeanUtils.copyProperties(entity,customerPreferenceEntity);
			allCustomersList.add(customerPreferenceEntity);
         }
		return allCustomersList;
	}
}
