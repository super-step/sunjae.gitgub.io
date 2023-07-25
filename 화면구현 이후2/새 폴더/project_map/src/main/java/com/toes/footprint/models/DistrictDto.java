package com.toes.footprint.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {
	private String dis_code;
	private String dis_name;
	private int dis_deeplv;
}
