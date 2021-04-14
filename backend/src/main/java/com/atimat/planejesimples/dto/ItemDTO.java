package com.atimat.planejesimples.dto;

import java.time.Instant;

import com.atimat.planejesimples.entities.Item;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemDTO {

	private Long id;
	private String title;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dueDate;
	private Double expectancy;
	private Double reality;
	
	public ItemDTO() {
	}

	public ItemDTO(Long id, String title, Instant dueDate, Double expectancy, Double reality, PlanningDTO planning) {
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.expectancy = expectancy;
		this.reality = reality;
	}
	
	public ItemDTO(Item entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.dueDate = entity.getDueDate();
		this.expectancy = entity.getExpectancy();
		this.reality = entity.getReality();
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
}
