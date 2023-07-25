package com.toes.footprint.service;

import com.toes.footprint.models.MemberDto;

public interface MemberService {
//	회원가입 
	public int join(MemberDto memberDto);
	
//	로그인 
	public String login(MemberDto memberDto);
	
//	아이디 찾기 
	public MemberDto findById(String id);
	
//	비밀번호 찾기(미정) 
	public MemberDto findByPassword(String password);
	
		
	
}
