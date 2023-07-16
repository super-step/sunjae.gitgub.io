package com.toes.footprint.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.toes.footprint.config.QualifierConfig;
import com.toes.footprint.dao.PostDao;
import com.toes.footprint.models.SnspostDto;
import com.toes.footprint.service.SnspostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	

	
	/*
	 * @Qualifier(QualifierConfig.SERVICE.FILE_V2)
	 * component 가 여러개면 어느것에 주입받을지 알 수 없어
	 * 이때는 @Component("이름") 에 이름을 부여하고
	 * 사용할 곳에서 주입받을때  @Qualifier() 를 통해 명시적으로
	 * 어떤 Component 를 주입받을지 지정해 주어야 한다
	 */
	
	
	protected final SnspostService snspostService;
	private final PostDao postDao;
	
	public HomeController(
			@Qualifier(QualifierConfig.SERVICE.FILE_V2) 
			SnspostService snspostService,
			PostDao postDao) {
		this.snspostService = snspostService;
		this.postDao = postDao;
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<SnspostDto> snspostList = postDao.findUserSelectLimit();
		model.addAttribute("SNSPOSTLIST", snspostList);
		return "home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "input";
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	/*
	 * 매개변수 설명
	 * BBDto bbsDto
	 * 	: input tag에 입력한 게시판 관련 text 를 받는 곳
	 * MultipartFile b_file
	 * 	: input tag 의 type="file" 에서 선택한 파일을 받는 곳
	 */
	public String insert(
		SnspostDto snspostDto,
		@RequestParam(value="b_file") MultipartFile b_file,
		Model model
		) {
		
//		log.debug("사용자이름 : {}",bbsDto.getB_username());
//		log.debug(b_file.getOriginalFilename());
		
		String fileName = null;
		try {
			fileName = snspostService.fileup(b_file);
			snspostDto.setB_image(fileName);
			int result = postDao.insert(snspostDto);
			return "redirect:/";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
//			log.debug("파일을 업로드 할수 없음 오류 발생!!");
			return "redirect:/insert?error=FILE_UP_ERROR";
		}
		
//		model.addAttribute("FILE_NAME",fileName);
//		return "input";
		
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String seq,Model model) {
		
		SnspostDto snspostDto = postDao.findById(seq);
//		밑에 수정
		model.addAttribute("BBS",snspostDto);
		return "detail";
		
	}
	
	
	
}
