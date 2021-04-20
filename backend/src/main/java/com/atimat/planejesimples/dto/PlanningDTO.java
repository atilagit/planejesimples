package com.atimat.planejesimples.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.atimat.planejesimples.entities.Item;
import com.atimat.planejesimples.entities.Planning;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PlanningDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant initialDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant finalDate;
	
	private Double expectedEntry;
	private Double totalExpectedSpend = 0.0;
	private Double expectedResult = 0.0;

	private Double realEntry;
	private Double totalRealSpend = 0.0;
	private Double realResult = 0.0;

	private UserDTO user;
	
	private List<ItemDTO> items = new ArrayList<>();
	
	public PlanningDTO() {
	}

	public PlanningDTO(Long id, Instant initialDate, Instant finalDate, Double expectedEntry, Double realEntry,
			UserDTO user, List<Item> items) {
		this.id = id;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.expectedEntry = expectedEntry;
		this.realEntry = realEntry;
		this.user = user;
		items.forEach(item -> this.items.add(new ItemDTO(item)));
		calculateData();
	}
	
	public PlanningDTO(Planning entity) {
		this.id = entity.getId();
		this.initialDate = entity.getInitialDate();
		this.finalDate = entity.getFinalDate();
		this.expectedEntry = entity.getExpectedEntry();
		this.realEntry = entity.getRealEntry();
		this.user = new UserDTO(entity.getUser());
		entity.getItems().forEach(item -> this.items.add(new ItemDTO(item)));
		calculateData();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Instant initialDate) {
		this.initialDate = initialDate;
	}

	public Instant getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Instant finalDate) {
		this.finalDate = finalDate;
	}

	public Double getExpectedEntry() {
		return expectedEntry;
	}

	public void setExpectedEntry(Double expectedEntry) {
		this.expectedEntry = expectedEntry;
	}

	public Double getRealEntry() {
		return realEntry;
	}

	public void setRealEntry(Double realEntry) {
		this.realEntry = realEntry;
	}

	public UserDTO getUser() {
		return user;
	}

	public Double getTotalExpectedSpend() {
		return totalExpectedSpend;
	}

	public void setTotalExpectedSpend(Double totalExpectedSpend) {
		this.totalExpectedSpend = totalExpectedSpend;
	}

	public Double getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(Double expectedResult) {
		this.expectedResult = expectedResult;
	}

	public Double getTotalRealSpend() {
		return totalRealSpend;
	}

	public void setTotalRealSpend(Double totalRealSpend) {
		this.totalRealSpend = totalRealSpend;
	}

	public Double getRealResult() {
		return realResult;
	}

	public void setRealResult(Double realResult) {
		this.realResult = realResult;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<ItemDTO> getItems() {
		return items;
	}
	
	public void calculateData() {
		for (ItemDTO item : items) {
			totalExpectedSpend += item.getExpectancy();
			totalRealSpend += item.getReality();
		}
		expectedResult = expectedEntry - totalExpectedSpend;
		realResult = realEntry - totalRealSpend;
	}
}
