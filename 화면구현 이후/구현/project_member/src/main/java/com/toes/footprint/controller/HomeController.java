package com.toes.footprint.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.toes.footprint.models.MemberDto;
import com.toes.footprint.service.MemberService;

@Controller
public class HomeController {

	protected MemberService memberService;

	public HomeController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

//	메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "/member/home";
	}


	
//	로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(name = "ERROR", required = false) String ERROR,
			@ModelAttribute("MEMBER") MemberDto memberDto, Model model) {
		model.addAttribute("ERROR", ERROR);
		return "/member/login";
	}

//	로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("MEMBER") MemberDto memberDto, HttpSession httpSession,
			SessionStatus sessionStatus) {
		MemberDto resultDto;
		try {
			resultDto = memberService.login(memberDto);
			httpSession.setAttribute("LOGINUSER", resultDto);
		} catch (Exception e) {
//		new Exception(message)라고 보낸 Exception 에서 
//		message에 해당하는 부분 getter 하기
			String message = e.getMessage();
			return "redirect:/user/login?ERROR=" + message;
		}
		sessionStatus.setComplete();
		return "redirect:/";
	}

//	 마이페이지
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String loginhome( String mb_id, Model model) {

		return "/member/mypage";
	}

}
