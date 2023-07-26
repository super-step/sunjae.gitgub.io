package com.toes.footprint.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.toes.footprint.models.MemberDto;
import com.toes.footprint.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("MEMBERLOGIN")
@Slf4j
@Controller
public class HomeController {

	protected final MemberService memberService;

	public HomeController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

//	메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "/member/home";
	}

//	회원가입 페이지 GET

	@RequestMapping(value = "/join", method = RequestMethod.GET)
//	newMember에서 MEMBER 객체를 만들고 /member/join에 전달
	public String join(@ModelAttribute("MEMBER") MemberDto memberDto) {
//	memberDto를 insert에 전달하고 그 값을int result 에 전달하겠다 
		return "/member/join";
	}

//	회원가입 페이지 POST
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("MEMBER") MemberDto memberDto, Model model) {
		log.debug("회원정보 확인@!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", memberDto);
		try {
			int result = memberService.insert(memberDto);
		} catch (Exception e) {
			/*
			 * 중복값이 있다면 service에서 throw 온 메세지를 getter한 것을 input에 보냄. 메세지를 출력해야 하기 때문에 리턴값은
			 * 회원가입페이지
			 */
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			return "member/join";
		}
		return "redirect:/login";
	}

//	로그인페이지 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(name = "ERROR", required = false) String errorMessage,
			@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model) {

		if (errorMessage != null) {
			model.addAttribute("ERROR", errorMessage);
		}
		return "/member/login";
	}

//	로그인페이지 POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("MEMBERLOGIN") MemberDto memberDto,String modal, HttpSession httpSession) {

		try {
			memberDto = memberService.login(memberDto);
			
			MemberDto modaldto= memberService.findById(modal);
			
			
			
			return "redirect:/";
		} catch (Exception e) {
			return "redirect:/login?ERROR=" + e.getMessage();
		}

	}

//	 마이페이지
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String loginhome(String mb_id, Model model) {

		return "/member/mypage";
	}

//	개발자소개 페이지
	@RequestMapping(value = "/developer", method = RequestMethod.GET)
	public String profile(Model model) {
		return "/member/profile";
	}

//	로그인에 객체를 넣어주기 위한 메서드
	@ModelAttribute("MEMBERLOGIN")
	public MemberDto loginMemberDto() {
		return MemberDto.builder().build();
	}

//	회원가입에 객체를 넣어주기 위한 메서드
	@ModelAttribute("MEMBER")
	public MemberDto newMember() {
		return MemberDto.builder().build();
	}

}
