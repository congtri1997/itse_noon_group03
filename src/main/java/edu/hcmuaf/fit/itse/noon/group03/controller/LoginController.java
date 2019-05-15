package edu.hcmuaf.fit.itse.noon.group03.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.hcmuaf.fit.itse.noon.group03.service.LoginService;
import edu.hcmuaf.fit.itse.noon.group03.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberService memberService;
//	@Autowired
//	private SocialLoginService socialLoginService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam("userName") String userName,
			@RequestParam("password") String password, Model model) {

		boolean login = loginService.login(userName, password);
		if (login) {
			session.setAttribute("member", memberService.getMemberByUserName(userName));
			return "redirect:/profile";
		} else {
			model.addAttribute("loginError", "Tài khoản hoặc mật khẩu không đúng");
			return "login";
		}
	}

	@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
	public String success() {
		return "success";
	}

}
