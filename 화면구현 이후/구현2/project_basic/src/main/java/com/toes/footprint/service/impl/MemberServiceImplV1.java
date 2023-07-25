package com.toes.footprint.service.impl;

import org.springframework.stereotype.Service;

import com.toes.footprint.models.MemberDto;
import com.toes.footprint.service.MemberService;

@Service
public class MemberServiceImplV1 implements MemberService{

	@Override
	public int join(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String login(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto findByPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
