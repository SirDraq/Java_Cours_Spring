package com.AndrzejJarosz.module.car.dto;

public class CarDto {

	private String guid;
	private String make;
	private String model;
	private Long year;
	private String vin;
	private String color;
	private String company;
	private String price;
	private CarDetailsDto details;

	public String getGuid() {
		return guid;
	}

	public CarDto setGuid(String guid) {
		this.guid = guid;
		return this;
	}

	public String getMake() {
		return make;
	}

	public CarDto setMake(String make) {
		this.make = make;
		return this;
	}

	public String getModel() {
		return model;
	}

	public CarDto setModel(String model) {
		this.model = model;
		return this;
	}

	public Long getYear() {
		return year;
	}

	public CarDto setYear(Long year) {
		this.year = year;
		return this;
	}

	public String getVin() {
		return vin;
	}

	public CarDto setVin(String vin) {
		this.vin = vin;
		return this;
	}

	public String getColor() {
		return color;
	}

	public CarDto setColor(String color) {
		this.color = color;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public CarDto setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public CarDto setPrice(String price) {
		this.price = price;
		return this;
	}

	public CarDetailsDto getDetails() {
		return details;
	}

	public CarDto setDetails(CarDetailsDto details) {
		this.details = details;
		return this;
	}
}
