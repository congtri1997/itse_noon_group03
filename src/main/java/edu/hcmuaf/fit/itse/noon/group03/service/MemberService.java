package edu.hcmuaf.fit.itse.noon.group03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.repository.MemberDAO;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public List<String> getUsedEmails() {
		return memberDAO.getListEmail();
	}

	public void addMember(Member member) {
		memberDAO.save(member);
	}

	public List<Member> getMembers() {
		return memberDAO.getListMember();
	}
}
