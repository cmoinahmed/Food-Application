package com.ty.frozenbottle.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class FoodMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	private List<Product> product;

	@OneToOne
	@JoinColumn
	private Admin admin;

}
