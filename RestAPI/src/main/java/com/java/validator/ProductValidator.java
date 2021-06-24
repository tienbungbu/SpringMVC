package com.java.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java.entity.Product;
import com.java.model.ProductDTO;

public class ProductValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ProductDTO productDTO = (ProductDTO) target;
		
		if(productDTO.getName() == null || productDTO.getName().length() == 0 ) {
			errors.rejectValue("name", "field.required");
		}
		
		if(productDTO.getPrice() == null ) {
			errors.rejectValue("quantity", "field.required");
		}
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required");
		
	}

}
