package edu.hcmuaf.fit.itse.noon.group03.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class FormAddMember {
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotBlank
	private String fullName;
	@NotBlank

	private String birthday;
	private String female;
	private String education;
	private String address;
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;

	@AssertTrue(message = "passVerify field should be equal than pass field")
	private boolean isValid() {
		return password == null ? false : password.equals(confirmPassword);
	}

	public FormAddMember(String email, String password, String confirmPassword, String fullName, String birthday,
			String female, String education, String address, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.fullName = fullName;
		this.birthday = birthday;
		this.female = female;
		this.education = education;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public FormAddMember() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
