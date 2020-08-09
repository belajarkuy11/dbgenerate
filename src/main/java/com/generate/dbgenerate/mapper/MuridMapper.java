package com.generate.dbgenerate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.generate.dbgenerate.dto.MuridDto;
import com.generate.dbgenerate.model.Murid;

@Mapper(componentModel = "spring")
public interface MuridMapper {

	@Mapping(source = "m.kela.nama", target = "kelasNama")
	@Mapping(source = "m.kela.id", target = "kelasId")
	MuridDto toDto(Murid m);
}
