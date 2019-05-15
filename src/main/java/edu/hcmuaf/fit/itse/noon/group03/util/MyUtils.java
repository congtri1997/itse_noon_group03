package edu.hcmuaf.fit.itse.noon.group03.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.security.crypto.password.PasswordEncoder;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;

public class MyUtils {

	public static FormMember convertMemberToFormUpdateMember(Member member) {
		FormMember formUpdateMember = new FormMember();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formUpdateMember.setDateOfBirth(formatter.format(member.getDateOfBirth()));
		formUpdateMember.setEmail(member.getEmail());
		formUpdateMember.setFirstName(member.getFirstName());
		formUpdateMember.setLastName(member.getLastName());
		formUpdateMember.setPhoneNumber(member.getPhone());
		formUpdateMember.setUserName(member.getUserName());
		formUpdateMember.setID(member.getID());
		return formUpdateMember;
	}

	public static void convertFormUpdateMemberToMember(FormMember formUpdateMember, Member member) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		member.setDateOfBirth(LocalDate.parse(formUpdateMember.getDateOfBirth(), formatter));
		member.setFirstName(formUpdateMember.getFirstName());
		member.setLastName(formUpdateMember.getLastName());
		member.setPhone(formUpdateMember.getPhoneNumber());
		
	}

	public static Member convertFormMemberToMember(FormMember formAddMember, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setEmail(formAddMember.getEmail());
		member.setPassword(passwordEncoder.encode(formAddMember.getPassword()));
		member.setPhone(formAddMember.getPhoneNumber());
		member.setFirstName(formAddMember.getFirstName());
		member.setLastName(formAddMember.getLastName());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		member.setDateOfBirth(LocalDate.parse(formAddMember.getDateOfBirth(), formatter));
		member.setUserName(formAddMember.getUserName());
		return member;
	}

}
