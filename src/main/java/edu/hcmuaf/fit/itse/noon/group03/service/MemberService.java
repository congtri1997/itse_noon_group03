package edu.hcmuaf.fit.itse.noon.group03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;
import edu.hcmuaf.fit.itse.noon.group03.repository.MemberDAO;
import edu.hcmuaf.fit.itse.noon.group03.util.MyUtils;

@Service
@Transactional
public class MemberService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberDAO memberDAO;

	public List<String> getUsedEmails() {
		return memberDAO.getListEmail();
	}

	public void addMember(FormMember formAddMember) {
		memberDAO.save(MyUtils.convertFormMemberToMember(formAddMember, passwordEncoder));
	}

	public List<Member> getMembers() {
		return memberDAO.getListMember();
	}

	public Member getMemberByEmail(String email) {
		return memberDAO.getOneByEmail(email);
	}

	public Member getMemberByUserName(String userName) {
		return memberDAO.getOneByUserName(userName);
	}

	public void updateProfile(FormMember formUpdateMember) {
		Member member = memberDAO.getMemberByID(formUpdateMember.getID());
		MyUtils.convertFormUpdateMemberToMember(formUpdateMember, member);
		memberDAO.save(member);
	}

	public void updatePassword(FormMember formUpdateMember) {
		Member member = memberDAO.getMemberByID(formUpdateMember.getID());
		member.setPassword(passwordEncoder.encode(formUpdateMember.getPassword()));
		memberDAO.save(member);
	}
}
