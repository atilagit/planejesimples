package com.atimat.planejesimples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atimat.planejesimples.entities.User;
import com.atimat.planejesimples.respositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<User> findAll(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public User findById(Long id){
		return repository.findById(id).orElse(null);
	}
}
