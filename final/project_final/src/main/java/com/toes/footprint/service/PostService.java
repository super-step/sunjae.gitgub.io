package com.toes.footprint.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.toes.footprint.models.PostDto;

public interface PostService {

	public List<PostDto> findByMkseq(long mk_seq);

	int insert(PostDto postDto, MultipartHttpServletRequest sp_images);

	
	// 여기부터@@@@
	List<PostDto> findByMbseq(long mb_seq);

// 여기까지 1개 추가@@@@
}
