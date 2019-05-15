package edu.hcmuaf.fit.itse.noon.group03.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;
import edu.hcmuaf.fit.itse.noon.group03.service.MemberService;
import edu.hcmuaf.fit.itse.noon.group03.util.MyUtils;
import edu.hcmuaf.fit.itse.noon.group03.validator.MemberAddvalidator;
import edu.hcmuaf.fit.itse.noon.group03.validator.MemberUpdatevalidator;
import edu.hcmuaf.fit.itse.noon.group03.validator.UpdatePasswordValidator;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberAddvalidator memberAddValidator;

	@Autowired
	private MemberUpdatevalidator memberUpdateValidator;
	@Autowired
	private UpdatePasswordValidator updatePasswordValidator;

	@RequestMapping(value = { "/", "/member/list" }, method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "list_member";
	}

	@RequestMapping(value = { "/member/add" }, method = RequestMethod.GET)
	public String addMember(Model model) {
		FormMember formAddMember = new FormMember();
		model.addAttribute("formAddMember", formAddMember);
		return "add_member";
	}

	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public String doAddThanhVien(@ModelAttribute("formAddMember") @Valid FormMember formAddMember, BindingResult result,
			ModelMap modelMap) {
		memberAddValidator.validate(formAddMember, result);
		if (result.hasErrors()) {
			return "add_member";
		}

		memberService.addMember(formAddMember);
		return "redirect:/member/list";
	}

	@RequestMapping(value = { "/profile", }, method = RequestMethod.GET)
	public String profile(Model model, HttpSession session) {
		if (session.getAttribute("member") == null)
			return "redirect:/login";
		return "profile";
	}

	@RequestMapping(value = { "/profile/updateprofile", }, method = RequestMethod.GET)
	public String updateProfile(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if (member == null)
			return "redirect:/login";
		model.addAttribute("formUpdateMember", MyUtils.convertMemberToFormUpdateMember(member));
		return "update_profile";
	}

	@RequestMapping(value = { "/profile/updateprofile" }, method = RequestMethod.POST)
	public String doUpdateProfile(Model model, HttpSession session,
			@ModelAttribute("formUpdateMember") @Valid FormMember formUpdateMember, BindingResult result) {
		Member member = (Member) session.getAttribute("member");
		if (member == null)
			return "redirect:/login";
		memberUpdateValidator.validate(formUpdateMember, result);
		if (result.hasErrors()) {
			return "update_profile";
		}
		formUpdateMember.setID(member.getID());
		memberService.updateProfile(formUpdateMember);
		return "update_profile";
	}

	@RequestMapping(value = { "/profile/changepassword", }, method = RequestMethod.GET)
	public String changePassword(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if (member == null)
			return "redirect:/login";
		model.addAttribute("formChangePassword", new FormMember());
		return "change_password";
	}

	@RequestMapping(value = { "/profile/changepassword" }, method = RequestMethod.POST)
	public String doChangePassword(Model model, HttpSession session,
			@ModelAttribute("formChangePassword") @Valid FormMember formUpdateMember, BindingResult result) {
		Member member = (Member) session.getAttribute("member");
		if (member == null)
			return "redirect:/login";
		updatePasswordValidator.validate(formUpdateMember, result);
		if (result.hasErrors()) {
			return "change_password";
		}
		formUpdateMember.setID(member.getID());
		memberService.updatePassword(formUpdateMember);
		model.addAttribute("message", "Đổi mật khẩu thành công");
		return "change_password";
	}

}
