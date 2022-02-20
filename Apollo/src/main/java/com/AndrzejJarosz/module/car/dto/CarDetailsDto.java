package com.AndrzejJarosz.module.car.dto;

public class CarDetailsDto {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public CarDetailsDto setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CarDetailsDto setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
}
