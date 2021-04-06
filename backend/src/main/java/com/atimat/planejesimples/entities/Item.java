package com.atimat.planejesimples.entities;

import java.io.Serializable;
import java.time.Instant;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private Instant dueDate;
	private Double expectancy;
	private Double reality;
	
	public Item() {
	}

	public Item(Long id, String title, Instant dueDate, Double expectancy, Double reality) {
		super();
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.expectancy = expectancy;
		this.reality = reality;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
