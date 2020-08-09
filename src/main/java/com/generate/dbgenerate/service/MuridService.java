package com.generate.dbgenerate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.dbgenerate.dto.MuridDto;
import com.generate.dbgenerate.mapper.MuridMapper;
import com.generate.dbgenerate.model.Murid;
import com.generate.dbgenerate.repository.MuridRepository;

@Service
public class MuridService {

	@Autowired
	MuridRepository muridRepository;
	
	@Autowired
	MuridMapper muridMapper;
	
	public List<MuridDto> findMuridByKelas(Long kelas) {
		Optional<List<Murid>> optLst = muridRepository.getMuridByKelasNative(kelas);
		List<MuridDto> l = optLst.isPresent()
				? getList(optLst.get())
				: new ArrayList<MuridDto>();
		return l;
	}
	
	List<MuridDto> getList(List<Murid> l) {
		List<MuridDto> ldto = new ArrayList<MuridDto>();
		for(Murid m : l)
			ldto.add(getDto(m));
		return ldto;
	}
	
	MuridDto getDto(Murid m) {
		return muridMapper.toDto(m);
	}
}
