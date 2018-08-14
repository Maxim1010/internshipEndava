package com.endava.example.domain.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.endava.example.domain.dto.CustomerDTO;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.invalid");
        
        CustomerDTO customerDTO = (CustomerDTO) obj;
        if (!customerDTO.getPhone().startsWith("0")) {
            errors.rejectValue("phone", "phone.invalid", new Object[]{ }, "");
        }

	}

}
