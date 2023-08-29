package com.selvita.demo.api;

import com.selvita.demo.dto.CarDTO;
import com.selvita.demo.dto.CarDataDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

public interface CarControllerApi {

    List<CarDTO> getCarList(
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice);

    CarDTO getCarById(Long id);

    CarDTO addCar(CarDataDTO carDTO);

    CarDTO updateCar(Long id, CarDataDTO carDTO);

    void deleteCar(Long id);
}
