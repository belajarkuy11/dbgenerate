package com.generate.dbgenerate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generate.dbgenerate.model.Kela;
import com.generate.dbgenerate.model.dto.KelasDto;
import com.generate.dbgenerate.service.KelasService;

@RestController
@RequestMapping("/dbapi")
public class KelasController {

	@Autowired
	KelasService kelasService;
	
	@GetMapping("/kelas/all")
	public ResponseEntity<?> getAll() {
		Optional< List<KelasDto> > opt = kelasService.listKelas();
		ResponseEntity<?> r = opt.isPresent() ? new ResponseEntity<List<KelasDto>>(opt.get(), HttpStatus.OK)
				:  new ResponseEntity<String>("NULL", HttpStatus.NOT_FOUND);
		
		return r;
	}
	
	@GetMapping("/kelas/{id}")
	public ResponseEntity<?> getById( @PathVariable(value = "id")Long id) {
		Optional<KelasDto> opt = kelasService.findByid(id);
		ResponseEntity<?> r = opt.isPresent() ? new ResponseEntity<KelasDto>(opt.get(), HttpStatus.OK)
				: new ResponseEntity<String>("NULL", HttpStatus.NOT_FOUND);
		
		return r;
	}
	
	@PostMapping("/kelas/save")
	public ResponseEntity<?> save(@RequestBody Kela pKl) {
		Kela k = kelasService.saveKelas(pKl);
		return new ResponseEntity<Long>(k.getId(), HttpStatus.OK);
	}
	
	@PutMapping("/kelas/update/{oldNama}/{newNama}")
	public ResponseEntity<?> update(@PathVariable(value = "oldNama")String oldNama, 
										@PathVariable(value = "newNama")String newNama) {
		Optional<KelasDto> opt = kelasService.updateKelas(oldNama, newNama);
		ResponseEntity<?> r = opt.isPresent() ? new ResponseEntity<KelasDto>(opt.get(), HttpStatus.OK)
				: new ResponseEntity<String>("NULL", HttpStatus.NOT_FOUND);
		return r;
	}
	
	@DeleteMapping("/kelas/delete/{nama}")
	public ResponseEntity<?> delete(@PathVariable(value = "nama")String nama) {
		Boolean ret = kelasService.deleteKelas(nama);
		ResponseEntity<?> r = ret ? new ResponseEntity<String>("SUKSES DELETE", HttpStatus.OK)
				: new ResponseEntity<String>("NOT FOUND", HttpStatus.NOT_FOUND);
		return r;
	}
}
