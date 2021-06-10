package com.java.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java.model.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(user.getName() == null || user.getName().length() == 0 ) {
			errors.rejectValue("name", "field.required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "field.required");
		
		if(user.getPhoneNumber().length() <9 || user.getPhoneNumber().length() >12) {
			errors.rejectValue("phoneNumber", "phoneNumber.invalid");
		}
	}

}
