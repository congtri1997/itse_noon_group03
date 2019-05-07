package edu.hcmuaf.fit.itse.noon.group03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.fit.itse.noon.group03.service.MemberService;

@RestController
public class ValidateRestfulController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/restful/validateEmail", method = RequestMethod.GET, produces = "application/json")
	public String validateEmailExist(@RequestParam(value = "email") String email) {

		List<String> list = memberService.getUsedEmails();

		if (list.contains(email))
			return "false";
		return "true";
	}

}
