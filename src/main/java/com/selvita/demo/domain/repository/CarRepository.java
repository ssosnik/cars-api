package com.selvita.demo.domain.repository;

import com.selvita.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}