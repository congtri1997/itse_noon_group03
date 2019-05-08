package edu.hcmuaf.fit.itse.noon.group03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.form.FormAddMember;
import edu.hcmuaf.fit.itse.noon.group03.repository.MemberDAO;

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

	public void addMember(FormAddMember formAddMember) {
		memberDAO.save(formAddMember.convertToEntity(passwordEncoder));
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
}
