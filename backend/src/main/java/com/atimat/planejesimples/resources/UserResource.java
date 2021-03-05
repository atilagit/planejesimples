package com.atimat.planejesimples.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atimat.planejesimples.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		list.add(new User(5L, "Atila", "atila__7@hotmail.com", "321"));
		list.add(new User(6L, "Mateus", "mateus__6@hotmail.com", "123"));
		return ResponseEntity.ok().body(list);
	}
}
