package com.ty.frozenbottle.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Proper Email Required")
	@NotBlank
	private String email;

	@Column(unique = true)
	@NotNull

	private Long phone;

	private String password;
	
	@NotNull
	private LocalDate dob;

	@OneToOne(mappedBy = "customer")
	private FoodOrder foodOrder;

	@ManyToOne
	@JoinColumn
	private Admin admin;

}