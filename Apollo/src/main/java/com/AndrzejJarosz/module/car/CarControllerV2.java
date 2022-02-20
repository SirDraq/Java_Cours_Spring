package com.AndrzejJarosz.module.car;

import com.AndrzejJarosz.core.pagination.ListResponse;
import com.AndrzejJarosz.module.car.dto.CarDto;
import com.AndrzejJarosz.module.car.entity.CarEntity;
import com.AndrzejJarosz.module.car.mapper.CarMapper;
import com.AndrzejJarosz.module.car.repository.CarPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CarControllerV2 {

	@Autowired
	private CarPagingAndSortingRepository repository;

	@GetMapping("/api/v2/cars")
	public ListResponse<CarDto> getCars(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size",defaultValue = "10") int size) {

		Pageable pageable = PageRequest.of(page,size);

		Page<CarEntity> carPage = repository.findAll(pageable);

		return new ListResponse(
				(CarMapper.map(carPage.getContent())),
				carPage.getTotalPages(),
				carPage.getTotalElements(),
				carPage.getSize(),
				carPage.getNumber());
	}
}
