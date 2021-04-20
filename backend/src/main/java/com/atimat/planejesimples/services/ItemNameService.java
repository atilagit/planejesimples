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

import com.atimat.planejesimples.dto.ItemNameDTO;
import com.atimat.planejesimples.entities.ItemName;
import com.atimat.planejesimples.respositories.ItemNameRepository;
import com.atimat.planejesimples.services.exceptions.DatabaseException;
import com.atimat.planejesimples.services.exceptions.ResourceNotFoundException;

@Service
public class ItemNameService {
	
	@Autowired
	private ItemNameRepository repository;

	@Transactional(readOnly = true)
	public List<ItemNameDTO> findAll(){
		List<ItemName> list = repository.findAll();
		return list.stream().map(x -> new ItemNameDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ItemNameDTO findById(Long id) {
		Optional<ItemName> obj = repository.findById(id);
		ItemName entity = obj.orElseThrow(() -> new ResourceNotFoundException("Planejamento não encontrado"));
		return new ItemNameDTO(entity);
	}

	@Transactional
	public ItemNameDTO update(Long id, ItemNameDTO dto) {
		try {
			ItemName entity = repository.getOne(id);
			updateEntity(dto, entity);
			entity = repository.save(entity);
			return new ItemNameDTO(entity);
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

	private void updateEntity(ItemNameDTO dto, ItemName entity) {
		entity.setName(dto.getName());
	}
}
