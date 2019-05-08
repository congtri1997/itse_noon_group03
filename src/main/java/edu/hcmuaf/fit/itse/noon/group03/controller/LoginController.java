package edu.hcmuaf.fit.itse.noon.group03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.hcmuaf.fit.itse.noon.group03.mail.GmailSender;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private GmailSender gmailSender;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {

		boolean login = loginService.login(userName, password);
		if (login) {

			return "success";
		} else {
			return "login";
		}
	}

}
