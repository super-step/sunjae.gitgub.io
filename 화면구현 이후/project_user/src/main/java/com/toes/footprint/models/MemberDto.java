package com.toes.footprint.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
	private long mb_seq;//	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
	private String mb_id;//	VARCHAR(30)	NOT NULL,	
	private String mb_password;//	VARCHAR(100)	NOT NULL,	
	private String mb_nick;//	VARCHAR(10)	NOT NULL,	
	private String mb_proimg;//	VARCHAR(100),		
	private String mb_name;//	VARCHAR(20)	NOT NULL,	
	private String mb_birth;//	VARCHAR(10)	NOT NULL,	
	private String mb_tel;//	VARCHAR(12)	NOT NULL,	
	private String mb_email;//	VARCHAR(40)	NOT NULL,	
	private String mb_addr;//	VARCHAR(200)		

	
	
	
	public long getMb_seq() {
		return mb_seq;
	}
	public void setMb_seq(long mb_seq) {
		this.mb_seq = mb_seq;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_password() {
		return mb_password;
	}
	public void setMb_password(String mb_password) {
		this.mb_password = mb_password;
	}
	public String getMb_nick() {
		return mb_nick;
	}
	public void setMb_nick(String mb_nick) {
		this.mb_nick = mb_nick;
	}
	public String getMb_proimg() {
		return mb_proimg;
	}
	public void setMb_proimg(String mb_proimg) {
		this.mb_proimg = mb_proimg;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_birth() {
		return mb_birth;
	}
	public void setMb_birth(String mb_birth) {
		this.mb_birth = mb_birth;
	}
	public String getMb_tel() {
		return mb_tel;
	}
	public void setMb_tel(String mb_tel) {
		this.mb_tel = mb_tel;
	}
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_addr() {
		return mb_addr;
	}
	public void setMb_addr(String mb_addr) {
		this.mb_addr = mb_addr;
	}


	
}
