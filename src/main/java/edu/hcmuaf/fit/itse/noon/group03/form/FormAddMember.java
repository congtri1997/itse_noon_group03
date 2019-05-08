package edu.hcmuaf.fit.itse.noon.group03.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.security.crypto.password.PasswordEncoder;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;

public class FormAddMember {
	private String email;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;

	private String dateOfBirth;
//	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;

	private String userName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Member convertToEntity(PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(passwordEncoder.encode(password));
		member.setPhone(phoneNumber);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		member.setDateOfBirth(LocalDate.parse(dateOfBirth, formatter));
		member.setUserName(userName);
		return member;
	}

}
