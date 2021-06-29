package com.atimat.planejesimples.dto;

import java.io.Serializable;
import java.time.Instant;

import com.atimat.planejesimples.entities.Item;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dueDate;
	private Double expectancy;
	private Double reality;
	
	@JsonProperty("itemName")
	private ItemNameDTO itemNameDTO;
	private PlanningDTO planningDTO;
	
	public ItemDTO() {
	}

	public ItemDTO(Long id, ItemNameDTO itemNameDTO, Instant dueDate, Double expectancy, Double reality, PlanningDTO planningDTO) {
		this.id = id;
		this.itemNameDTO = itemNameDTO;
		this.dueDate = dueDate;
		this.expectancy = expectancy;
		this.reality = reality;
		this.planningDTO = planningDTO;
		this.title = itemNameDTO.getName();
	}
	
	public ItemDTO(Item entity) {
		this.id = entity.getId();
		this.itemNameDTO = new ItemNameDTO(entity.getItemName());
		this.dueDate = entity.getDueDate();
		this.expectancy = entity.getExpectancy();
		this.reality = entity.getReality();
		this.title = entity.getItemName().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}

	public Double getExpectancy() {
		return expectancy;
	}

	public void setExpectancy(Double expectancy) {
		this.expectancy = expectancy;
	}

	public Double getReality() {
		return reality;
	}

	public void setReality(Double reality) {
		this.reality = reality;
	}

	public ItemNameDTO getItemNameDTO() {
		return itemNameDTO;
	}

	public void setItemNameDTO(ItemNameDTO itemNameDTO) {
		this.itemNameDTO = itemNameDTO;
	}

	public PlanningDTO getPlanningDTO() {
		return planningDTO;
	}

	public void setPlanningDTO(PlanningDTO planningDTO) {
		this.planningDTO = planningDTO;
	}
}
