package com.atimat.planejesimples.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atimat.planejesimples.dto.ItemNameDTO;
import com.atimat.planejesimples.services.ItemNameService;

@RestController
@RequestMapping(value = "/item-names")
public class ItemNameResource {
	
	@Autowired
	private ItemNameService service;
	
	@GetMapping
	public ResponseEntity<List<ItemNameDTO>> findAll(){
		List<ItemNameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemNameDTO> findById(@PathVariable Long id){
		ItemNameDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ItemNameDTO> update(@PathVariable Long id, @RequestBody ItemNameDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ItemNameDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}
}
