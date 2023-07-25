package com.toes.footprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toes.footprint.config.QualifierConfig;
import com.toes.footprint.dao.MemberDao;
import com.toes.footprint.models.MemberDto;
import com.toes.footprint.service.MemberService;

@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService {

	protected final MemberDao memberDao;

	public MemberServiceImplV1(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}

//	테이블 자동 생성 메서드 
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
		} else if (resultDto != null && !memberDto.getMb_password().equals(resultDto.getMb_password())) {
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

	/*
	 * 회원을 등록할 때 새로운 코드를 생성해 memberDto에 업데이트고 회원정보 insert 하기
	 */
	@Override
	public int insert(MemberDto memberDto) throws Exception {
//		아이디 중복 방지 코드
		String id = memberDto.getMb_id();
		MemberDto resultDtoid = memberDao.findid(id);
		if (resultDtoid != null) {
			throw new Exception("ID");
		}

//		이름과 전화번호가 중복되지 않게 하는 코드. .trim() 을 붙여서 빈칸 제거 필요
		String tel = memberDto.getMb_tel().trim();
		String name = memberDto.getMb_name().trim();
		MemberDto resultDtotelname = memberDao.findnameandtel(name, tel);
//		만약 중복됐다면
		if (resultDtotelname != null) {
			throw new Exception("NAME_TEL");
		}

//		닉네임이 중복되지 않게 하는코드
		String nickname = memberDto.getMb_nick().trim();
		MemberDto resultDtonickname = memberDao.findnickname(nickname);
		if (resultDtonickname != null) {
			throw new Exception("NICKNAME");
		}

//		이메일이 중복되지 않게 하는코드		
		String email = memberDto.getMb_email().trim();
		MemberDto resultDtoemail = memberDao.findemail(email);
		if(resultDtoemail != null) {
			throw new Exception("EMAIL");
		}
		
		
		// seq는 이미 자동증가값인데 진짜 필요한가
		String mCode = this.getNewCode();
//		memberDto.set

		return memberDao.insert(memberDto);
	}

// tb_member 를 조회해 새로운 고객코드를 생성하는 메서드
	@Override
	public String getNewCode() {
		String mCode = memberDao.getMaxMcode();
		String newCode = "00001";
		if (mCode != null) {
			String.format("%06d", Integer.valueOf(mCode) + 1);
		}
		return null;// newCode;
	}

}
