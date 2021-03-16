package com.atimat.planejesimples.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atimat.planejesimples.dto.PlanningDTO;
import com.atimat.planejesimples.entities.Planning;
import com.atimat.planejesimples.entities.User;
import com.atimat.planejesimples.respositories.PlanningRepository;
import com.atimat.planejesimples.respositories.UserRepository;
import com.atimat.planejesimples.services.exceptions.ResourceNotFoundException;

@Service
public class PlanningService {
	
	@Autowired
	private PlanningRepository repository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<PlanningDTO> findAll(){
		List<Planning> list = repository.findAll();
		return list.stream().map(x -> new PlanningDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PlanningDTO findById(Long id) {
		Optional<Planning> obj = repository.findById(id);
		Planning entity = obj.orElseThrow(() -> new ResourceNotFoundException("Planejamento não encontrado"));
		return new PlanningDTO(entity);
	}

	@Transactional
	public PlanningDTO insert(PlanningDTO dto) {
		User user = userRepository.getOne(dto.getUser().getId());
		Planning entity = new Planning(null, dto.getInitialDate(), dto.getFinalDate(), dto.getExpectedEntry(), dto.getRealEntry(), user);
		entity = repository.save(entity);
		return new PlanningDTO(entity);
	}
}
