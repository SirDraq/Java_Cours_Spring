package com.AndrzejJarosz.module.car.repository;

import com.AndrzejJarosz.module.car.entity.CarEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPagingAndSortingRepository extends PagingAndSortingRepository<CarEntity, Long> {
}