package org.hashtag.Hospital.controller;

import java.util.List;

import org.hashtag.Hospital.entity.Hospital;
import org.hashtag.Hospital.entity.ResponseStructure;
import org.hashtag.Hospital.repo.HosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hos")
public class HosController {
	
	@Autowired
	HosRepo hr;
	
	@PostMapping("/")
	public ResponseStructure<Hospital> createHos(@RequestBody Hospital hs){
		hr.save(hs);
		return new ResponseStructure<Hospital>(HttpStatus.CREATED.value(),hs,"Done");
	}
	
	@GetMapping("/all")
	public ResponseStructure<List<Hospital>> getAll(){
		List<Hospital> lh=hr.findAll();
		return new ResponseStructure<List<Hospital>>(HttpStatus.CREATED.value(),lh,"Done");
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Hospital> findBYId(@PathVariable int id){
		Hospital h= hr.findById(id).orElse(null);
		return new ResponseStructure<Hospital>(HttpStatus.CREATED.value(),h,"Done");
	}
	
}
