package com.toes.footprint.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.toes.footprint.models.MemberDto;

public interface MemberDao {

//	가장 높은 seq 값(최신값)을 불러오는 메서드
	@Select("SELECT MAX(mb_seq) FROM tb_member")
	public String getMaxMcode();

//	회원가입에서 아이디 중복값이 있는지 확인
	@Select(" SELECT * FROM tb_member WHERE mb_id = #{mb_id} ")
	public String findjoinbyid();

//  회원가입
	public int insert(MemberDto memberDto);

//	정보수정
	public int update(MemberDto memberDto);

//	아이디 찾기 
	@Select(" SELECT * FROM tb_member WHERE mb_id = #{id} ")
	public MemberDto findById(String id);

//	비밀번호 찾기
	@Select("SELECT * FROM tb_member WHERE mb_password = #{password} ")
	public MemberDto findByPassword(String password);

//	테이블 생성 
	public void creat_member_table(String dumy);

//	아이디 중복방지
	@Select("SELECT * FROM tb_member WHERE mb_id = #{id} ")
	public MemberDto findid(String id);

//	이름과 전화 중복방지
	@Select("SELECT * FROM tb_member WHERE mb_name = #{name} AND mb_tel = #{tel}  ")
	public MemberDto findnameandtel(@Param("name") String name, @Param("tel")String tel);

	// 닉네임 중복방지
	@Select("SELECT * FROM tb_member WHERE mb_nick = #{nickname} ")
	public MemberDto findnickname(String nickname);

//	이메일 중복방지
	@Select("SELECT * FROM tb_member WHERE mb_email = #{email}")
	public MemberDto findemail(String email);

}
