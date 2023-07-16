package com.toes.footprint.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toes.footprint.dao.DistrictDao;
import com.toes.footprint.models.DistrictDto;
import com.toes.footprint.service.DistrictService;

@Service
public class DistrictServiceImplV1 implements DistrictService {

	protected final DistrictDao districtDao;
	
	public DistrictServiceImplV1(DistrictDao districtDao) {
		super();
		this.districtDao = districtDao;
	}

	@Override
	public List<DistrictDto> SelectAll() {
		return districtDao.selectAll();
	}

	@Override
	public DistrictDto findByCode(String code) {
		return districtDao.findByCode(code);
	}


	
}
