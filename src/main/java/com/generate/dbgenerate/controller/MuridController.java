package com.generate.dbgenerate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generate.dbgenerate.dto.MuridDto;
import com.generate.dbgenerate.service.MuridService;

@RestController
@RequestMapping("/api/tutorial")
public class MuridController {

	@Autowired
	MuridService muridService;
	
	@GetMapping(value = "/murid/bykelas/{kelas}", produces = {"application/json"})
	public ResponseEntity<?> getMuridByKelas(@PathVariable(value = "kelas")Long kelas) {
		return new ResponseEntity<List<MuridDto>>(muridService.findMuridByKelas(kelas), HttpStatus.OK);
	}
	
}
