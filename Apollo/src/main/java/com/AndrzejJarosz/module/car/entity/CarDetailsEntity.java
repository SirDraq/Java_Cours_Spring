package com.AndrzejJarosz.module.car.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_details")
public class CarDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public Long getId() {
		return id;
	}

	public CarDetailsEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public CarDetailsEntity setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CarDetailsEntity setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
}

