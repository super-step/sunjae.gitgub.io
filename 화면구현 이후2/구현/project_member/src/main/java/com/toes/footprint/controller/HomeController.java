package com.toes.footprint.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.toes.footprint.models.MemberDto;
import com.toes.footprint.service.MemberService;

import lombok.extern.slf4j.Slf4j;

//@SessionAttributes("MEMBERLOGINMODAL")
//@SessionAttributes("MEMBERLOGIN")
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
	public String home(Model model, HttpSession httpSession) {
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("MEMBERLOGIN");

		return "/member/home";
	}

//	로그아웃 (httpSession삭제)이건 아직 미완성
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession httpSession) {
		// HttpSession을 무효화하여 로그아웃 처리
		httpSession.invalidate();
		// 홈페이지로 리다이렉트
		return "redirect:/";
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
	public String login(@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, HttpSession httpSession) {

		try {
			memberDto = memberService.login(memberDto);
//			밑에서 만든 @ModelAttribute("MEMBERLOGIN") 을 HttpSession에 적용
//			별 일이 없는 이상 내역이 삭제되지 않음 
			httpSession.setAttribute("MEMBERLOGIN", memberDto);
			return "redirect:/";
		} catch (Exception e) {
			return "redirect:/login?ERROR=" + e.getMessage();
		}
	}

	@RequestMapping(value = "/loginmodal", method = RequestMethod.GET)
	public String loginmodal(@RequestParam(name = "ERROR", required = false) String errorMessage,
			@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model, SessionStatus sessionStatus,
			HttpSession httpSession) {

//		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{}",memberDto.toString());
		if (errorMessage != null) {
			model.addAttribute("ERROR", errorMessage);
		}
		return "/member/loginmodal";
	}

	@RequestMapping(value = "/loginmodal", method = RequestMethod.POST)
	public String loginmodal(@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model,
			SessionStatus sessionStatus) {
		MemberDto resultDto = null;
		try {
			resultDto = memberService.findIdByEmail(memberDto);
			model.addAttribute("MEMBERLOGIN", resultDto);
//			impl에서 에러메세지를 설정 안한다. 
//			catch문에서는 impl에서 입력한 message를 리턴하고 있는데 이건 실패했을 경우다
//			try문에서는 직접적으로 "OK"라는 값을 리턴해서 JSP에서 OK라는 메세지를 받게 하는 것이다.
			return "redirect:/loginmodal?ERROR=OK";
		} catch (Exception e) {
//			log.debug("******************************************전달값{}", memberDto);
			return "redirect:/loginmodal?ERROR=" + e.getMessage();
		}
	}

//
////	로그인모달에 객체를 넣어주기 위한 메서드
//	@ModelAttribute("MEMBERLOGINMODAL")
//	public MemberDto loginModalMemberDto() {
//		return MemberDto.builder().build();
//	}

//	 마이페이지
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, HttpSession httpSession) {
//		로그인을 위한 @ModelAttribute를 dto로 형변환
//		memberDto = (MemberDto) httpSession.getAttribute("MEMBERLOGIN");
		if (memberDto == null) {
			// 로그인 안됨
			return "redirect:/login";
		}

//		만약 로그인이 안됐을 경우 전달하는 페이지

		log.debug("GET**********************{}",memberDto.toString());
//	로그인이 되면 이동할 페이지
		return "/member/mypage";
	}

	
//	 마이페이지
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String mypage(@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model, HttpSession httpSession) {

		//		로그인을 위한 @ModelAttribute를 dto로 형변환
		//		resultDto 는 로그인해서 가져온 dto값
	MemberDto resultDto = (MemberDto) httpSession.getAttribute("MEMBERLOGIN");
	// 로그인 안됨, resultDto는 그저 현재 로그인 세션을 보여주는 dto값일 뿐이다
		if (resultDto == null) {
			return "redirect:/login";
		}
		
		log.debug("########################################{}",resultDto);
		log.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$${}",memberDto);

		try {
			int result = memberService.update(memberDto);
//		memberDTO는 내가 input tag에서 입력한 값으로 그 값을 resultDto에 넣어주는 것이 아니라 session에 넣어주어야 한다.			
			log.debug("변경한 값**********************{}",memberDto.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//	로그인이 되면 이동할 페이지
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
