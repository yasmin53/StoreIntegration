package com.usecase.storeservice.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;

import com.usecase.storeservice.entity.StoreEntity;
import com.usecase.storeservice.model.StoreModel;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StoreValidations {

	public boolean validate(StoreEntity store) {
		if (isValidateName(store.getName()) == false || store.getName() == null) {
			log.info("Reenter StoreName");
			return false;
		}
		if (isValidateContact(store.getContact()) == false) {
			log.info("please check the mobile number that you entered");
			return false;
		}
		return true;
	}

	private boolean isValidateContact(long phone) {
		if (phone > 9999999999L && phone < 6000000000L)
			return false;
		else
			return true;
	}

	private boolean isValidateName(String name) {
		String regex = "[aA-zZ]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	
}
