package com.generate.dbgenerate.controller;

import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generate.dbgenerate.model.Lab;
import com.generate.dbgenerate.repository.LabRepository;

@RestController
@RequestMapping("/api/v3")
public class LabController {

	@Autowired
	LabRepository labRepository;
	
	@PutMapping(value = "/update/id/{id}/nama/{nama}", produces = {"application/json"})
	public ResponseEntity<?> updateLabNameById(@PathVariable(value = "id")Integer id, 
												@PathVariable(value = "nama")String nama) 
			throws URISyntaxException {
		Optional<Integer> opt = Optional.ofNullable(labRepository.updateLaNamebById(id, nama));
		
		return new ResponseEntity<Integer>(opt.get(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/lab", produces = {"application/json"})
	public ResponseEntity<?> updateLab(@RequestBody Lab l) {
		Optional<Lab> lab = Optional.ofNullable(labRepository.save(l));
		return new ResponseEntity<Lab>(lab.get(), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/delete/lab", produces = {"application/json"})
	public ResponseEntity<?> deleteLab(@RequestBody Lab l) {
		labRepository.delete(l);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/lab/id/{id}", produces = {"application/json"})
	public ResponseEntity<?> deleteLabById(@PathVariable(value = "id")Integer id) {
		Integer ret = labRepository.deleteByIdLab(id);
		String desc = ret == 1 ? "SUCCESS" : "NOT FOUND";
		return new ResponseEntity<String>(desc, HttpStatus.OK);
	}
}
