package com.AndrzejJarosz.module.car.repository;

import com.AndrzejJarosz.module.car.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long>, JpaSpecificationExecutor<CarEntity> {

    CarEntity getOneByGuid(String guid);

    List<CarEntity> findAllByColor(String color);

    List<CarEntity> findAllByMake(String make);

    List<CarEntity> findAllByYearGreaterThan(Long year);
}

