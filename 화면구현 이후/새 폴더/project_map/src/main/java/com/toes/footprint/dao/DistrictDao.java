package com.toes.footprint.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.toes.footprint.models.DistrictDto;

public interface DistrictDao {
	
	@Select("SELECT * FROM tb_district")
	public List<DistrictDto> selectAll();
	
	@Select("SELECT * FROM tb_district WHERE dis_code = #{code}")
	public DistrictDto findByCode(String code);
	
	
}
