package com.atimat.planejesimples.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atimat.planejesimples.dto.UserDTO;
import com.atimat.planejesimples.entities.User;
import com.atimat.planejesimples.respositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id){
		User obj = repository.findById(id).orElse(null);
		return new UserDTO(obj);
	}
}
