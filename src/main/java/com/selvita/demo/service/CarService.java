package com.selvita.demo.service;

import com.selvita.demo.dto.CarDTO;
import com.selvita.demo.dto.CarDataDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();

    List<CarDTO> getCarsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    CarDTO getCarById(Long id);

    CarDTO addCar(CarDataDTO carDTO);

    CarDTO updateCar(Long id, CarDataDTO updatedCarDTO);

    void deleteCar(Long id);
}