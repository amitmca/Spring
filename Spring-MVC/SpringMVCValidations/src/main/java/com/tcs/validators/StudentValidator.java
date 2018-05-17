package com.tcs.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.tcs.domain.Student;

public class StudentValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
		return Student.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age","age.required");
	}
}