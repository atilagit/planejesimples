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

import com.atimat.planejesimples.dto.ItemDTO;
import com.atimat.planejesimples.entities.Item;
import com.atimat.planejesimples.entities.ItemName;
import com.atimat.planejesimples.entities.Planning;
import com.atimat.planejesimples.respositories.ItemNameRepository;
import com.atimat.planejesimples.respositories.ItemRepository;
import com.atimat.planejesimples.respositories.PlanningRepository;
import com.atimat.planejesimples.services.exceptions.DatabaseException;
import com.atimat.planejesimples.services.exceptions.ResourceNotFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private PlanningRepository planningRepository;
	
	@Autowired
	private ItemNameRepository itemNameRepository;

	@Transactional(readOnly = true)
	public List<ItemDTO> findAll(){
		List<Item> list = repository.findAll();
		return list.stream().map(x -> new ItemDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ItemDTO findById(Long id) {
		Optional<Item> obj = repository.findById(id);
		Item entity = obj.orElseThrow(() -> new ResourceNotFoundException("Planejamento não encontrado"));
		return new ItemDTO(entity);
	}
	
	@Transactional
	public ItemDTO insert(ItemDTO dto) {
		ItemName itemName = itemNameRepository.getOne(dto.getItemNameDTO().getId());
		Planning planning = planningRepository.getOne(dto.getPlanningDTO().getId());
		Item entity = new Item(null, itemName, dto.getDueDate(), dto.getExpectancy(), dto.getReality(), planning);
		entity = repository.save(entity);
		return new ItemDTO(entity);
	}

	@Transactional
	public ItemDTO update(Long id, ItemDTO dto) {
		try {
			Item entity = repository.getOne(id);
			updateEntity(dto, entity);
			entity = repository.save(entity);
			return new ItemDTO(entity);
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

	private void updateEntity(ItemDTO dto, Item entity) {
		ItemName itemName = itemNameRepository.getOne(dto.getItemNameDTO().getId());
		entity.setItemName(itemName);
		entity.setExpectancy(dto.getExpectancy());
		entity.setReality(dto.getReality());
		entity.setDueDate(dto.getDueDate());
	}
}
