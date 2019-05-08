package edu.hcmuaf.fit.itse.noon.group03.validator;

import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.hcmuaf.fit.itse.noon.group03.form.FormAddMember;

@Component
public class MemberAddvalidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FormAddMember.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		FormAddMember formAddMember = (FormAddMember) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.formAddMember.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.formAddMember.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.formAddMember.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.formAddMember.dateOfBirth");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.formAddMember.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.formAddMember.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.formAddMember.confirmPassword");
		
		
	}

}
