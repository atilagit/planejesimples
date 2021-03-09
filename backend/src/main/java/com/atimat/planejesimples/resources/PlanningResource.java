package com.atimat.planejesimples.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atimat.planejesimples.entities.Planning;
import com.atimat.planejesimples.services.PlanningService;

@RestController
@RequestMapping(value = "/plannings")
public class PlanningResource {
	
	@Autowired
	private PlanningService service;
	
	@GetMapping
	public ResponseEntity<List<Planning>> findAll(){
		List<Planning> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Planning> findById(@PathVariable Long id){
		Planning obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
