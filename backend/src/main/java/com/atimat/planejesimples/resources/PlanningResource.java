package com.atimat.planejesimples.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atimat.planejesimples.dto.PlanningDTO;
import com.atimat.planejesimples.services.PlanningService;

@RestController
@RequestMapping(value = "/plannings")
public class PlanningResource {
	
	@Autowired
	private PlanningService service;
	
	@GetMapping
	public ResponseEntity<List<PlanningDTO>> findAll(){
		List<PlanningDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlanningDTO> findById(@PathVariable Long id){
		PlanningDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PlanningDTO> insert(@RequestBody PlanningDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
