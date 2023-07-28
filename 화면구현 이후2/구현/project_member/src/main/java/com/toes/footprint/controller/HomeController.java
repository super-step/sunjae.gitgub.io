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


//@SessionAttributes("MEMBERLOGINMODAL")
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
			@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model, String modal, String id) {

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
			@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model,SessionStatus sessionStatus,HttpSession httpSession) {

		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{}",memberDto.toString());
		if (errorMessage != null) {
			model.addAttribute("ERROR", errorMessage);
		}
//		유효성 검사 결과 나올 데이터
//		model.addAttribute("MEMBERLOGINMODAL", memberDto);
		return "/member/loginmodal";
	}

	
	@RequestMapping(value = "/loginmodal", method = RequestMethod.POST)
	public String loginmodal(@ModelAttribute("MEMBERLOGIN") MemberDto memberDto, Model model,SessionStatus sessionStatus) {
//		MemberDto resultDto;

		
		MemberDto resultDto = null;
		try {
			resultDto = memberService.findIdByEmail(memberDto);
			model.addAttribute("MEMBERLOGIN",resultDto);
			return "redirect:/loginmodal?ERROR=OK";
		} catch (Exception e) {
//			httpSession.setAttribute("MEMBERLOGIN",memberDto);
//			memberDto = memberService.findById(memberDto.getMb_id());
//			model.addAttribute("MEMBERLOGINMODAL", memberDto);
			log.debug("******************************************전달값{}", memberDto);
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
	public String loginhome(String mb_id, Model model, HttpSession httpSession) {
//		로그인을 위한 @ModelAttribute를 dto로 형변환
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("MEMBERLOGIN");

//		만약 로그인이 안됐을 경우 전달하는 페이지
		if (memberDto == null) {
			// 로그인 안됨
			return "redirect:/member/login";
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
