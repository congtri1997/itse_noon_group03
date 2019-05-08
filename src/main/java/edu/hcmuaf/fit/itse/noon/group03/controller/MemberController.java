package edu.hcmuaf.fit.itse.noon.group03.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.form.FormAddMember;
import edu.hcmuaf.fit.itse.noon.group03.service.MemberService;
import edu.hcmuaf.fit.itse.noon.group03.util.MyUtils;
import edu.hcmuaf.fit.itse.noon.group03.validator.MemberAddvalidator;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberAddvalidator memberAddValidator;

	@RequestMapping(value = { "/", "/member/list" }, method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "list_member";
	}

	@RequestMapping(value = { "/member/add" }, method = RequestMethod.GET)
	public String addMember(Model model) {
		FormAddMember formAddMember = new FormAddMember();
		model.addAttribute("formAddMember", formAddMember);
		return "add_member";
	}

	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public String doAddThanhVien(@ModelAttribute("formAddMember") @Valid FormAddMember formAddMember,
			BindingResult result, ModelMap modelMap) {
		memberAddValidator.validate(formAddMember, result);
		if (result.hasErrors()) {
			return "add_member";
		}

		memberService.addMember(formAddMember);
		return "redirect:/member/list";
	}

}
