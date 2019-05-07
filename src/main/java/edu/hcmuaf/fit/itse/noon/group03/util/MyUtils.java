package edu.hcmuaf.fit.itse.noon.group03.util;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.form.FormAddMember;

public class MyUtils {

	public static Member convertFormAddMembertoMember(FormAddMember formAddMember) {
		Member member = new Member();
		member.setAddress(formAddMember.getAddress());
		member.setBirthday(formAddMember.getBirthday());
		member.setEducation(formAddMember.getEducation());
		member.setEmail(formAddMember.getEmail());
		String gender = formAddMember.getFemale();
		System.out.println("gender: " + gender);
		boolean temp = false;
		if (gender != null) {
			if (gender.equalsIgnoreCase("true"))
				temp = true;
			else if (gender.equalsIgnoreCase("false"))
				temp = false;
		}
		member.setFemale(temp);
		System.out.println("boolean temp: " + temp);
		// member.setFemale(gender == null ? false : gender.equalsIgnoreCase("true") ?
		// true : false);
		member.setFullName(formAddMember.getFullName());
		member.setPassword(formAddMember.getPassword());
		member.setPhone(formAddMember.getPhoneNumber());
		return member;
	}

}
