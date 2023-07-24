package com.toes.footprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toes.footprint.dao.MemberDao;
import com.toes.footprint.models.MemberDto;
import com.toes.footprint.service.MemberService;

@Service
public class MemberServiceImplV1 implements MemberService {

	protected final MemberDao memberDao;

	public MemberServiceImplV1(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}

	@Autowired
	public void creat_member_table() {
			memberDao.creat_member_table(null);
	}
	
//	회원가입메서드. 관리자 안넣기로 함
	@Override
	public int join(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}

//	isBlank 사용(빈칸일시)
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if (memberDto.getMb_id().isBlank()) {
			throw new Exception("MEMBER_EMPTY");
		} else if (memberDto.getMb_password().isBlank()) {
			throw new Exception("PASSWORD_EMPTY");
		}
//		객체를 새로 만들어 db에서 id를 찾아 resultDto에 저장 
		MemberDto resultDto = memberDao.findById(memberDto.getMb_id());
//		dto값이 비었다면 "MEMBERNAME" 을 controller에 예외를 보냄
		if (resultDto == null) {
			throw new Exception("MEMBERNAME");
//			id값이 있고 비밀번호가 다를경우 "PASSWORD" 를 controller에 보냄
		}else if(resultDto!=null && !memberDto.getMb_password().equals(resultDto.getMb_password())) {
			throw new Exception("PASSWORD");
		}

		return resultDto;
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
