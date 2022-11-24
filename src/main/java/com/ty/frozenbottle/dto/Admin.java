package com.ty.frozenbottle.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@NotBlank
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Proper Email Required")
	@Column(unique = true)
	private String email;

	@Column(unique = true)
	@NotNull
	private Long phone;
	
	@NotBlank
	private String password;

	@OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
	private FoodMenu foodMenu;

	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Customer> customers;

}
