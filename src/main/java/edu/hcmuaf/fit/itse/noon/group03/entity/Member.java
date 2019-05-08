package edu.hcmuaf.fit.itse.noon.group03.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THANHVIEN")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATHVIEN")
	private long ID;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MATKHAU")
	private String password;

	@Column(name = "HO")
	private String lastName;

	@Column(name = "TEN")
	private String firstName;

	@Column(name = "NGSINH")
	private LocalDate dateOfBirth;

	@Column(name = "DIENTHOAI")
	private String phone;
	@Column(name = "TENTAIKHOAN")
	private String userName;

	public Member() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return lastName + " " + firstName;
	}

	@Override
	public String toString() {
		return "Member [ID=" + ID + ", email=" + email + ", password=" + password + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + ", phone=" + phone + ", userName="
				+ userName + "]";
	}

}
