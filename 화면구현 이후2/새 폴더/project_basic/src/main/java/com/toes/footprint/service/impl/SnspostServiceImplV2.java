package com.toes.footprint.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SnspostServiceImplV2 extends SnspostServiceImplV1 {

	protected final String windowPath;
	protected final String winPath;
	protected final String macHome;
	protected final String macPath;

	public SnspostServiceImplV2(ResourceLoader resource, String windowsPath, String winPath, String macHome,
			String macPath) {

		super();
		this.windowPath = windowsPath;
		this.winPath = winPath;
		this.macHome = macHome;
		this.macPath = macPath;
	}

	@Override
	public String fileup(MultipartFile file) throws Exception {
		String fileUpPath = macHome + macPath;
		File path = new File(windowsPath);
		if(path.exists()) {
			fileUpPath = winPath;
		}
		// 실제 업로드될 파일 이름
				String fileName = file.getOriginalFilename();
				
				// Java 제공하는 UUID 생성하는 코드
				String strUUID = UUID.randomUUID().toString();
				// image.jpg0000-0000-0000
				
				// UUID 키값을 파일이름 앞에  부착하여 새로운 이름으로 변형
				fileName = String.format("%s-%s", strUUID, fileName);
				
				File upLoadFile = new File(fileUpPath, fileName);
				file.transferTo(upLoadFile);
				return fileName;

			}

	@Override
	public List<String> fileup(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
