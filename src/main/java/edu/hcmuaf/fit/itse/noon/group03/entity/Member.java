package edu.hcmuaf.fit.itse.noon.group03.entity;

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

	@Column(name = "HOTEN")
	private String fullName;

	@Column(name = "NGSINH")
	private String birthday;

	@Column(name = "NU")
	private boolean female;

	@Column(name = "TDVANHOA")
	private String education;

	@Column(name = "DIACHI")
	private String address;

	@Column(name = "DIENTHOAI")
	private String phone;

	public Member(String email, String password, String fullName, String birthday, boolean female, String education,
			String address, String phone) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.birthday = birthday;
		this.female = female;
		this.education = education;
		this.address = address;
		this.phone = phone;
	}

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

	public boolean isFemale() {
		return female;
	}

	public void setFemale(boolean female) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
