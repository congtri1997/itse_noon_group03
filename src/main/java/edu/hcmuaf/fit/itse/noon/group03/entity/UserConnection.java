package edu.hcmuaf.fit.itse.noon.group03.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class UserConnection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String providerID;

	private String providerUserID;

	@OneToOne
	private Member member;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public String getProviderUserID() {
		return providerUserID;
	}

	public void setProviderUserID(String providerUserID) {
		this.providerUserID = providerUserID;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
