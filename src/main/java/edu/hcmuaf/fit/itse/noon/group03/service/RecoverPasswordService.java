package edu.hcmuaf.fit.itse.noon.group03.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.fit.itse.noon.group03.entity.ForgotPassword;
import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.mail.GmailSender;
import edu.hcmuaf.fit.itse.noon.group03.repository.ForgotPasswordDAO;
import edu.hcmuaf.fit.itse.noon.group03.repository.MemberDAO;

@Service
@Transactional
public class RecoverPasswordService {

	@Autowired
	private ForgotPasswordDAO forgotPassworDAO;
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private GmailSender gmailSender;

	public void createRecoverRequest(String email) {
		Member member = memberDAO.getOneByEmail(email);
		if (member != null) {
			ForgotPassword forgotPassword = new ForgotPassword();
			UUID uuid = UUID.randomUUID();
			LocalDateTime now = LocalDateTime.now();
			forgotPassword.setMember(member);
			forgotPassword.setExpireTime(now.plusMinutes(ForgotPassword.TIMEOUT_IN_MINUTE));
			forgotPassword.setToken(uuid.toString());
			forgotPassworDAO.addOneRecord(forgotPassword);

			String message = "http://localhost:8080/itse_noon_group03/recoverpassword/" + uuid;
			String mailTo = member.getEmail();
			gmailSender.sendMail("itse.noon.gr03@gmail.com", mailTo, "Recover password", message);
		}
	}

	public void changePassword(String token, String newPassword) {
		ForgotPassword forgotPassword = forgotPassworDAO.getOneByToken(token);
		if (forgotPassword != null) {
			if (!forgotPassword.isExpire()) {
				System.out.println("dô đc tới đây");
				Member member = forgotPassword.getMember();
				member.setPassword(passwordEncoder.encode(newPassword));
				memberDAO.save(member);
			}
			forgotPassworDAO.remove(forgotPassword);
		}
	}

}
