package com.AndrzejJarosz.module.car.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String guid;
	private String make;
	private String model;
	private Long year;
	private String vin;
	private String color;
	private String company;
	private String price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "details_id", referencedColumnName = "id")
	private CarDetailsEntity details;

	public Long getId() {
		return id;
	}

	public CarEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getGuid() {
		return guid;
	}

	public CarEntity setGuid(String guid) {
		this.guid = guid;
		return this;
	}

	public String getMake() {
		return make;
	}

	public CarEntity setMake(String make) {
		this.make = make;
		return this;
	}

	public String getModel() {
		return model;
	}

	public CarEntity setModel(String model) {
		this.model = model;
		return this;
	}

	public Long getYear() {
		return year;
	}

	public CarEntity setYear(Long year) {
		this.year = year;
		return this;
	}

	public String getVin() {
		return vin;
	}

	public CarEntity setVin(String vin) {
		this.vin = vin;
		return this;
	}

	public String getColor() {
		return color;
	}

	public CarEntity setColor(String color) {
		this.color = color;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public CarEntity setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public CarEntity setPrice(String price) {
		this.price = price;
		return this;
	}

	public CarDetailsEntity getDetails() {
		return details;
	}

	public CarEntity setDetails(CarDetailsEntity details) {
		this.details = details;
		return this;
	}
}
