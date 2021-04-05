package com.atimat.planejesimples.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atimat.planejesimples.dto.PlanningDTO;
import com.atimat.planejesimples.entities.Planning;
import com.atimat.planejesimples.entities.User;
import com.atimat.planejesimples.respositories.PlanningRepository;
import com.atimat.planejesimples.respositories.UserRepository;
import com.atimat.planejesimples.services.exceptions.DatabaseException;
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

	@Transactional
	public PlanningDTO update(Long id, PlanningDTO dto) {
		try {
			Planning entity = repository.getOne(id);
			updateEntity(dto, entity);
			entity = repository.save(entity);
			return new PlanningDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade");
		}
	}

	private void updateEntity(PlanningDTO dto, Planning entity) {
		entity.setInitialDate(dto.getInitialDate());
		entity.setFinalDate(dto.getFinalDate());
		entity.setExpectedEntry(dto.getExpectedEntry());
		entity.setRealEntry(dto.getRealEntry());
	}
}
