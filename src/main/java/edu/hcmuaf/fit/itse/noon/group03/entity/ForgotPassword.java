package edu.hcmuaf.fit.itse.noon.group03.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class ForgotPassword {

	public static final int TIMEOUT_IN_MINUTE = 5;

	@ManyToOne
	Member member;
	@Column
	private LocalDateTime expireTime;

	@Id
	private String token;

	public boolean isExpire() {
		LocalDateTime now = LocalDateTime.now();
		return now.isBefore(expireTime);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		LocalTime after5Min = LocalTime.now().plusMinutes(5);
		System.out.println(now.toString());
		System.out.println(after5Min.toString());
		System.out.println(after5Min.isAfter(now));
	}

}
