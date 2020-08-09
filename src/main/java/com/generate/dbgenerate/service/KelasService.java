package com.generate.dbgenerate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.generate.dbgenerate.dto.KelasDto;
import com.generate.dbgenerate.model.Kela;
import com.generate.dbgenerate.repository.KelasRepository;
import java.util.Optional;

@Service
public class KelasService {

	@Autowired
	KelasRepository kelasRepository;
	
	public Optional< List<KelasDto> > listKelas() {
		Optional<List<Kela>> optlk = Optional.ofNullable(kelasRepository.findAll()); 
		Optional<List<KelasDto>> optlkdo =  optlk.isPresent() ? Optional.ofNullable( getListDto(optlk.get())) : null; 
		return optlkdo;
	}
	
	public Optional<KelasDto> findByid(Long id) {
		Optional<Kela> opt = kelasRepository.findById(id);
		Optional<KelasDto> optkdo = opt.isPresent() ? Optional.ofNullable(getDto(opt.get())) : null;
		return optkdo;
	}
	
	public Kela saveKelas(Kela k) {
		return kelasRepository.save(k);
	}
	
	public Optional<KelasDto> updateKelas(String oldNama, String newNama) {
		Optional<Kela> kob = kelasRepository.findByNama(oldNama);
		kob.ifPresent( f -> f.setNama(newNama));
		KelasDto ret = kob.isPresent() ?  getDto( kelasRepository.save(kob.get()) ) : null;
		return Optional.ofNullable(ret);
	}
	
	public Boolean deleteKelas(String nama) {
		Optional<Kela> kob = kelasRepository.findByNama(nama);
		if(kob.isPresent()) {
			kelasRepository.delete(kob.get());
			return true;
		} 
		else return false;
	}
	
	List<KelasDto> getListDto(List<Kela> lk) {
		List<KelasDto> lkdto = new ArrayList<>();
		for(Kela k : lk)
			lkdto.add(getDto(k));
		
		return lkdto;
	}
	
	KelasDto getDto(Kela k) {
		KelasDto dto = new KelasDto();
		dto.setId(k.getId());
		dto.setNama(k.getNama());
		return dto;
	}
}
