package edu.hcmuaf.fit.itse.noon.group03.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.hcmuaf.fit.itse.noon.group03.entity.Member;
import edu.hcmuaf.fit.itse.noon.group03.form.FormMember;
import edu.hcmuaf.fit.itse.noon.group03.service.MemberService;
import edu.hcmuaf.fit.itse.noon.group03.service.SocialLoginService;
import edu.hcmuaf.fit.itse.noon.group03.util.FBUtils;
import edu.hcmuaf.fit.itse.noon.group03.util.GoogleUtils;
import edu.hcmuaf.fit.itse.noon.group03.validator.MemberAddvalidator;

@Controller
public class SocialLoginController {
	@Autowired
	private SocialLoginService socialLoginService;
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberAddvalidator memberAddValidator;

	@RequestMapping(value = { "/LoginController" }, method = RequestMethod.GET)
	public String socialLogin(@RequestParam("LoginType") String loginType, @RequestParam("code") String code,
			RedirectAttributes attributes, HttpSession session) {
		String providerUserID = null;
		switch (loginType) {
		case "google":
			try {
				providerUserID = GoogleUtils.getUserInfo(GoogleUtils.getToken(code));
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "fb":
			try {
				providerUserID = FBUtils.getUserInfo(FBUtils.getToken(code));
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			return "login";
		}

		if (socialLoginService.isSocialAccountExist(loginType, providerUserID)) {
			session.setAttribute("member", socialLoginService.getUserConnection(loginType, providerUserID).getMember());
			return "redirect:/profile";
		} else {
//			return "redirect:/registerSocialAccount/" + loginType + "/" + providerUserID + "/";
			attributes.addFlashAttribute("loginType", loginType);
			attributes.addFlashAttribute("providerUserID", providerUserID);
			return "redirect:/registerSocialAccount/";
		}
	}

	@RequestMapping(value = { "/registerSocialAccount" }, method = RequestMethod.GET)
	public String socialRegister(Model model, @ModelAttribute("loginType") String providerID,
			@ModelAttribute("providerUserID") String providerUserID) {
		System.out.println("userID " + providerUserID);
		model.addAttribute("providerUserID", providerUserID);
		model.addAttribute("providerID", providerID);
		FormMember formAddMember = new FormMember();
		model.addAttribute("formAddMember", formAddMember);
		return "socialRegister";
	}

//	@RequestMapping(value = { "/registerSocialAccount/{providerID}/{providerUserID}" }, method = RequestMethod.GET)
//	public String socialRegister(@PathVariable("providerID") String providerID,
//			@PathVariable("providerUserID") String providerUserID, Model model) {
//		System.out.println("userID " + providerUserID);
//		model.addAttribute("providerUserID", providerUserID);
//		model.addAttribute("providerID", providerID);
//		FormAddMember formAddMember = new FormAddMember();
//		model.addAttribute("formAddMember", formAddMember);
//		return "socialRegister";
//	}

	@RequestMapping(value = "/registerSocialAccount", method = RequestMethod.POST)
	public String doSocialRegister(@ModelAttribute("formAddMember") @Valid FormMember formAddMember,
			BindingResult result, ModelMap modelMap, @ModelAttribute("providerID") String providerID,
			@ModelAttribute("providerUserID") String providerUserID, RedirectAttributes attributes,
			HttpSession session) {
		memberAddValidator.validate(formAddMember, result);
		if (result.hasErrors()) {
//			attributes.addFlashAttribute("providerID", providerID);
//			attributes.addFlashAttribute("providerUserID", providerUserID);
			return "socialRegister";
		}
		memberService.addMember(formAddMember);

		Member member = memberService.getMemberByUserName(formAddMember.getUserName());
		System.out.println("Member info: " + member);
		socialLoginService.addMember(formAddMember.getUserName(), providerID, providerUserID);

		session.setAttribute("member", member);

		return "redirect:/profile";
	}

}
