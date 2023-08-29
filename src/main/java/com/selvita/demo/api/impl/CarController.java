package com.selvita.demo.api.impl;

import com.selvita.demo.api.CarControllerApi;
import com.selvita.demo.dto.CarDTO;
import com.selvita.demo.dto.CarDataDTO;
import com.selvita.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController implements CarControllerApi {

    private final CarService carService;

    @Override
    @GetMapping
    public List<CarDTO> getCarList(
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {

        if (minPrice != null || maxPrice != null) {
            return carService.getCarsByPriceRange(minPrice, maxPrice);
        } else {
            return carService.getAllCars();
        }
    }

    @Override
    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @Override
    @PostMapping
    public CarDTO addCar(@RequestBody CarDataDTO carDTO) {
        return carService.addCar(carDTO);
    }

    @Override
    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarDataDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}