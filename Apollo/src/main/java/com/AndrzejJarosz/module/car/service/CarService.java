package com.AndrzejJarosz.module.car.service;

import com.AndrzejJarosz.module.car.repository.CarRepository;
import com.AndrzejJarosz.module.car.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public CarEntity getOne(String guid) {
		return carRepository.getOneByGuid(guid);
	}

	public List<CarEntity> getAll(String color, String make, Long year) {

		if(color != null){
			return carRepository.findAllByColor(color);
		}
		if(make != null){
			return carRepository.findAllByMake(make);
		}
		if(year != null){
			return carRepository.findAllByYearGreaterThan(year);
		}

		return carRepository.findAll();
	}
}

