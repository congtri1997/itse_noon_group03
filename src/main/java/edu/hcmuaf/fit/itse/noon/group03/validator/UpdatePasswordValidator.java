package edu.hcmuaf.fit.itse.noon.group03.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;

@Component
public class UpdatePasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FormMember.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		FormMember formAddMember = (FormMember) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.formAddMember.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.formAddMember.confirmPassword");

		if (formAddMember.getPassword() != null
				&& !formAddMember.getPassword().equals(formAddMember.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Match.formAddMember.confirmPassword");
		}
	}

}
