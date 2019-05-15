package edu.hcmuaf.fit.itse.noon.group03.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;
import edu.hcmuaf.fit.itse.noon.group03.util.ValidatorUtil;

@Component
public class MemberUpdatevalidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		return FormMember.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		FormMember formAddMember = (FormMember) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.formAddMember.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.formAddMember.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.formAddMember.dateOfBirth");
		if (!ValidatorUtil.valdiateDate(formAddMember.getDateOfBirth())) {
			errors.rejectValue("dateOfBirth", "Pattern.formAddMember.dateOfBirth");
		}
		if (!ValidatorUtil.validatePhone(formAddMember.getPhoneNumber())) {
			errors.rejectValue("phoneNumber", "Pattern.formAddMember.phoneNumber");
		}
	}
}
