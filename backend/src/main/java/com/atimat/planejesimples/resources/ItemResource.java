package com.atimat.planejesimples.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atimat.planejesimples.dto.ItemDTO;
import com.atimat.planejesimples.services.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemResource {
	
	@Autowired
	private ItemService service;
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> findAll(){
		List<ItemDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemDTO> findById(@PathVariable Long id){
		ItemDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ItemDTO> insert(@RequestBody ItemDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ItemDTO> update(@PathVariable Long id, @RequestBody ItemDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ItemDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}
}
