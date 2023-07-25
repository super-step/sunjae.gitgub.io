package com.toes.footprint.dao;

import org.apache.ibatis.annotations.Select;

import com.toes.footprint.models.MemberDto;

public interface MemberDao {

//	회원가입에서 아이디 중복값이 있는지 확인
	@Select(" SELECT * FROM tb_member WHERE mb_id = #{mb_id} ")
	public String findjoinbyid(); 
	
	public int insert(MemberDto memberDto);
	
//	아이디 찾기 
	@Select(" SELECT * FROM tb_member WHERE mb_id = #{mb_id} ")
	public MemberDto findById(String id);

//	비밀번호 찾기(미정) 
	public MemberDto findByPassword(String password);

	
//	테이블 생성 
	public void creat_member_table(String dumy);
	
	
	
}
