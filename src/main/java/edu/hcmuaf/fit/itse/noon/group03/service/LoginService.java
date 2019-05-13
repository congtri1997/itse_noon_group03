package edu.hcmuaf.fit.itse.noon.group03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.repository.MemberDAO;

@Service
@Transactional
public class LoginService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean login(String userName, String password) {
		Member member = memberDAO.getOneByUserName(userName);
		if (member != null) {
			String hashedPassword = member.getPassword();
			return passwordEncoder.matches(password, hashedPassword);
		} else
			return false;
	}

}
