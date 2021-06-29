package com.atimat.planejesimples.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dueDate;
	private Double expectancy;
	private Double reality;
	
	@ManyToOne
	@JoinColumn(name = "planning_id")
	private Planning planning;
	
	@ManyToOne
	@JoinColumn(name = "itemName_id")
	private ItemName itemName;
	
	public Item() {
	}

	public Item(Long id, ItemName itemName, Instant dueDate, Double expectancy, Double reality, Planning planning) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.dueDate = dueDate;
		this.expectancy = expectancy;
		this.reality = reality;
		this.planning = planning;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public ItemName getItemName() {
		return itemName;
	}

	public void setItemName(ItemName itemName) {
		this.itemName = itemName;
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
