package com.toes.footprint.service.impl;

import org.springframework.stereotype.Service;

import com.toes.footprint.models.MemberDto;
import com.toes.footprint.persistance.MemberDao;
import com.toes.footprint.service.MemberService;

@Service
public class MemberServiceImplV1 implements MemberService {

	protected final MemberDao memberDao;

	public MemberServiceImplV1(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}

//		dao에 회원가입으로 그대로 리턴. 
//		중복값을 여기서 검사할려면 db에서 데이터를 가져와
//		만약 있다면 duplication이라는 문자열을 dto에 담아서 리턴
//		나중에 duplication 문자열이 있다면 사용할수 없는 메세지라 표시할 것
	@Override
	public int join(MemberDto memberDto) {
		String joinid = memberDao.findjoinbyid();
		if (joinid == memberDao.findjoinbyid()) {
			memberDto.setMb_id("duplication");
		}
		return memberDao.insert(memberDto);
	}

	@Override
	public String login(MemberDto memberDto) {
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
