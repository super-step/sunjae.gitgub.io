package com.toes.footprint.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SnspostService {

	
	/*
	 * 필요한 메서드:
	 *  1. 파일(멀티) 업로드
	 *  2. 파일 삭제
	 *  
	 */
	
	
	public String fileup(MultipartFile file) throws Exception;
	
//	멀티 파일 업로드
	public List<String> fileup (MultipartHttpServletRequest files)throws Exception;
	
	public String delete(String fileName); 
	
	
}
