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

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/", "/member/list" }, method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "member_list";
	}

	@RequestMapping(value = { "/member/add" }, method = RequestMethod.GET)
	public String addMember(Model model) {
		FormAddMember formAddMember = new FormAddMember();
		model.addAttribute("member", formAddMember);
		return "add_member";
	}

	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public String doAddThanhVien(@ModelAttribute("member") @Valid FormAddMember formAddMember, BindingResult result,
			ModelMap modelMap) {
		if (result.hasErrors()) {
			return "add_member";
		}

		Member member = MyUtils.convertFormAddMembertoMember(formAddMember);
		memberService.addMember(member);
		return "success";
	}

}
