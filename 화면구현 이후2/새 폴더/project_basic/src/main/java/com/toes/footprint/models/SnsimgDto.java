package com.toes.footprint.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SnsimgDto {
	private long spi_seq;// BIGINT
	private String spi_uri; // VARCHAR(100)
	private String spi_cdate;// VARCHAR(10)
	private long spi_spseq; // BIGINT

}
