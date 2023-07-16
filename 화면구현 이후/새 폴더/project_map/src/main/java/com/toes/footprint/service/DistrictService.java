package com.toes.footprint.service;

import java.util.List;

import com.toes.footprint.models.DistrictDto;

public interface DistrictService {
	public List<DistrictDto> SelectAll();
	public DistrictDto findByCode(String code);
}
