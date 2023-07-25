package com.toes.footprint.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SnspostDto {
	
	private long sp_seq;
	private String sp_title; // VARCHAR(30)
	private String sp_content; // VARCHAR(400)
	private String sp_cdate; // VARCHAR(10)
	private String sp_mdate; // VARCHAR(10)
	private long sp_mkseq; // BIGINT
	private long mb_seq; // BIGINT

}
