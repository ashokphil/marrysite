package com.ashok.marrysite.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ashok.marrysite.model.User;
@Component
public class UserFormValidator implements Validator{

	public boolean supports(Class<?> paramclass) {
		// TODO Auto-generated method stub
		return User.class.equals(paramclass);
	}

	public void validate(Object obj, Errors errors) {  
		// TODO Auto-generated method stub
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required"); 
		
		//User user = (User) obj;
				
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "religion", "religion.required");
	}
		
	}


