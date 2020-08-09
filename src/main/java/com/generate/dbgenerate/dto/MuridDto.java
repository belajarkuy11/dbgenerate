package com.generate.dbgenerate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MuridDto {
	private Integer id;
	private String alamat;
	private String nama;
	private Long umur;
	private Long kelasId;
	private String kelasNama;
}
