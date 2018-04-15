package org.avijitbarua.Controller;

import java.util.List;
import javax.validation.Valid;

import org.avijitbarua.Domain.Member;
import org.avijitbarua.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/")
	public String loginPage() {
		return "LoginPage";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String welcomePage(@RequestParam String userName, @RequestParam String password,
			@ModelAttribute("message") Member member, BindingResult bindingResult) {
		if (memberService.isAuthenticate(userName, password))

			return "WelcomePage";

		else {

			bindingResult.rejectValue("password", "error.idOutOfRange", "Invalid UserName or Password! Try Again!!");
			return "LoginPage";
		}

	}

	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model) {
		model.addAttribute(new Member());

		return "RegistrationPage";
	}

	@RequestMapping(value = "/doRegistration", method = RequestMethod.POST)
	public String doRegistration(Model model, @Valid Member member, BindingResult result) {
		if (result.hasErrors()) {
			return "RegistrationPage";
		}

		if (memberService.isExist(member.getUserName()) != null) {
			result.rejectValue("userName", "DuplicateKey.user.userName", "This username already exist! Try again !");
			return "RegistrationPage";
		} else {
			try {
				memberService.createMember(member);
			} catch (DuplicateKeyException e) {

			}

			return "SuccessPage";
		}

	}

	@RequestMapping("/memberList")
	public String memberList(Model model) {

		List<Member> list = memberService.getAlMember();
		model.addAttribute("list", list);
		return "MembersList";
	}

	@RequestMapping(value = "/deleteMember/userName={userName}", method = RequestMethod.GET)
	public String deleteMember(@PathVariable("userName") String userName, Model model) {
		memberService.deleteMember(userName);
		List<Member> list = memberService.getAlMember();
		model.addAttribute("list", list);
		return "MembersList";
	}

	@RequestMapping(value = "/editMember/userName={userName}", method = RequestMethod.GET)
	public String editMember(@PathVariable("userName") String userName, Model model) {

		Member member = memberService.isExist(userName);
		model.addAttribute(member);
		return "EditMember";
	}

	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public String updateMember(Model model, @Valid Member member) {
		memberService.createMember(member);
		List<Member> list = memberService.getAlMember();
		model.addAttribute("list", list);
		return "MembersList";
	}
}
