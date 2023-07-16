package com.toes.footprint.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.toes.footprint.models.SnspostDto;

public interface PostDao {

	
	@Select("SELECT * FROM tb_snspost ORDER BY sp_seq")
	public List<SnspostDto> selectAll();	
	
	
	
	public List<SnspostDto> findUserSelectLimit();
	
//	@Select(" SELECT * "
//			+ " FROM tbl_bbs"
//			+ "  LEFT JOIN tbl_user "
//			+ " 	ON b_username = username "
//			+ " WHERE b_seq = #{seq}")
	@Select("SELECT * FROM tb_snspost WHERE sp_seq = #{id}")
	public SnspostDto findById(String seq);

	public int insert(SnspostDto snspostDto);

	
	
	
}
