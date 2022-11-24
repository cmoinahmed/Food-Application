package com.ty.frozenbottle.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private double totalCost;

	@CreationTimestamp
	private LocalDateTime dateTime;

	@OneToMany(mappedBy = "foodOrder", cascade = CascadeType.ALL)
	private List<Item> items;
	
	@OneToOne
	@JoinColumn
	private Customer customer;

}
