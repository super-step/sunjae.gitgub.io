package com.toes.footprint.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.toes.footprint.dao.FileDao;
import com.toes.footprint.dao.PostDao;
import com.toes.footprint.models.FileDto;
import com.toes.footprint.models.PostDto;
import com.toes.footprint.service.FileService;
import com.toes.footprint.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImplV1 implements PostService{

	protected final PostDao postDao;
	protected final FileService fileService;
	private final FileDao fileDao;
	public PostServiceImplV1(PostDao postDao, FileService fileService, FileDao fileDao) {
		super();
		this.postDao = postDao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}

	@Override
	public List<PostDto> findByMkseq(long mk_seq) {
		List<PostDto> postDtoList = postDao.findByMkseq(mk_seq);
		for(PostDto postDto : postDtoList) {
			postDto.setSp_imgs(fileDao.findByBSeq(postDto.getSp_seq()));
		}
		return postDtoList;
	}
	
	@Override
	public int insert(
			PostDto postDto,
			MultipartHttpServletRequest sp_images) {
		// post 입력
		// files 저장
		// files DB에 경로 저장
		
		String fileName = null;
		 
		try {
			postDto.setSp_mbseq(1); //임시로 세팅. 실제로 하면 로그인된 session을 이용해 mbseq를 입력한다.
			int result = postDao.insert(postDto);
			log.debug("새로생성된 PK : {}", postDto.toString());
			
			
			// 멀티파일 업로드가 실행되었을때 만 filesUp() 호출
			
			// getFiles().size()
			// b_image 를 List 로 변환하고 개수 세기
			
			// getFile().getSize(),
			// 업로드한 파일의 개수가 담긴 변수값 참조
			
			if(sp_images.getFile("sp_images").getSize() > 0) {
				List<FileDto> files = fileService.filesUp(sp_images);
//				log.debug(files.toString());
				result = fileDao.insert(files, postDto.getSp_seq());
			}
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			log.debug("파일을 업로드 할수 없음 오류 발생!!");
			return -1;
		}
	}

	@Override
	public List<PostDto> findByMbseq(long mb_seq) {
		List<PostDto> postDtoList = postDao.findByMbseq(mb_seq);
		for(PostDto postDto : postDtoList) {
			postDto.setSp_imgs(fileDao.findByBSeq(postDto.getSp_seq()));
		}
		return postDtoList;
	}
	
}
