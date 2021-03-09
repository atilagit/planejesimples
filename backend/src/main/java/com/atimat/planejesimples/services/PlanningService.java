package com.atimat.planejesimples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atimat.planejesimples.entities.Planning;
import com.atimat.planejesimples.respositories.PlanningRepository;

@Service
public class PlanningService {
	
	@Autowired
	private PlanningRepository repository;

	@Transactional(readOnly = true)
	public List<Planning> findAll(){
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Planning findById(Long id) {
		Planning obj = repository.findById(id).orElse(null);
		return obj;
	}
}
