package edu.hcmuaf.fit.itse.noon.group03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.hcmuaf.fit.itse.noon.group03.service.RecoverPasswordService;

@Controller
public class RecoverPasswordController {

	@Autowired
	private RecoverPasswordService recoverPasswordService;

	@RequestMapping(value = { "/recoverpassword" }, method = RequestMethod.GET)
	public String recoverPassword() {

		return "recover";
	}

	@RequestMapping(value = { "/recoverpassword" }, method = RequestMethod.POST)
	public String recoverPassword(@RequestParam("email") String email) {
		System.out.println("create request");
		recoverPasswordService.createRecoverRequest(email);
		return "recover";
	}

	@RequestMapping(value = { "/recoverpassword/{token}" }, method = RequestMethod.GET)
	public String receive(Model model, @PathVariable("token") String token) {
		if (token == null)
			return "login";
		model.addAttribute("token", token);
		return "do_recover";
	}

	@RequestMapping(value = { "/recover" }, method = RequestMethod.POST)
	public String receive(@RequestParam("password") String newPassword, @RequestParam("token") String token) {
		recoverPasswordService.changePassword(token, newPassword);
		return "do_recover";
	}

}
