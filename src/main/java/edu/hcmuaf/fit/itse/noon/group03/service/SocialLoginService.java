package edu.hcmuaf.fit.itse.noon.group03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.entity.UserConnection;
import edu.hcmuaf.fit.itse.noon.group03.repository.MemberDAO;
import edu.hcmuaf.fit.itse.noon.group03.repository.UserConnectionDAO;

@Service
@Transactional
public class SocialLoginService {

	@Autowired
	private UserConnectionDAO userConnectionDAO;

	@Autowired
	private MemberDAO memberDAO;

	public boolean isSocialAccountExist(String providerID, String providerUserID) {
		return userConnectionDAO.checkExistUserConnection(providerID, providerUserID);
	}

	public UserConnection getUserConnection(String providerID, String providerUserID) {
		return userConnectionDAO.getOne(providerID, providerUserID);
	}

	public void addMember(String userName, String providerID, String providerUserID) {
		UserConnection userConnection = new UserConnection();
		Member member = memberDAO.getOneByUserName(userName);
		userConnection.setMember(member);
		userConnection.setProviderID(providerID);
		userConnection.setProviderUserID(providerUserID);
		userConnectionDAO.addOne(userConnection);
	}

}
