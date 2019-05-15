package edu.hcmuaf.fit.itse.noon.group03.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;
import edu.hcmuaf.fit.itse.noon.group03.service.MemberService;
import edu.hcmuaf.fit.itse.noon.group03.util.ValidatorUtil;

@Component
public class MemberAddvalidator implements Validator {

	private EmailValidator emailValidator = EmailValidator.getInstance();

	@Autowired
	private MemberService memberService;

	@Override
	public boolean supports(Class<?> clazz) {
		return FormMember.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		FormMember formAddMember = (FormMember) target;
		formAddMember.setEmail(formAddMember.getEmail() != null ? formAddMember.getEmail().trim() : null);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.formAddMember.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.formAddMember.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.formAddMember.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.formAddMember.dateOfBirth");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.formAddMember.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.formAddMember.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.formAddMember.confirmPassword");
		if (!emailValidator.isValid(formAddMember.getEmail())) {
			errors.rejectValue("email", "Pattern.formAddMember.email");
		}
		if (!ValidatorUtil.validateUsername(formAddMember.getUserName())) {
			errors.rejectValue("userName", "Pattern.formAddMember.userName");
		}
		if (!ValidatorUtil.valdiateDate(formAddMember.getDateOfBirth())) {
			errors.rejectValue("dateOfBirth", "Pattern.formAddMember.dateOfBirth");
		}
		if (!ValidatorUtil.validatePhone(formAddMember.getPhoneNumber())) {
			errors.rejectValue("phoneNumber", "Pattern.formAddMember.phoneNumber");
		}
		if (memberService.getMemberByEmail(formAddMember.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate.formAddMember.email");
		}
		if (memberService.getMemberByUserName(formAddMember.getUserName()) != null) {
			errors.rejectValue("userName", "Duplicate.formAddMember.userName");
		}
		if (formAddMember.getPassword() != null
				&& !formAddMember.getPassword().equals(formAddMember.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Match.formAddMember.confirmPassword");
		}
	}

}
