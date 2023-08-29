package com.selvita.demo.service.impl;

import com.selvita.demo.domain.Car;
import com.selvita.demo.domain.repository.CarRepository;
import com.selvita.demo.dto.CarDTO;
import com.selvita.demo.dto.CarDataDTO;
import com.selvita.demo.dto.mapper.CarDataMapper;
import com.selvita.demo.dto.mapper.CarMapper;
import com.selvita.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return CarMapper.INSTANCE.mapToDTOs(cars);
    }

    @Override
    public List<CarDTO> getCarsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {

        if (minPrice == null) {
            minPrice = BigDecimal.ZERO;
        }

        if (maxPrice == null) {
            maxPrice = new BigDecimal("1E9");
        }

        List<Car> cars = carRepository.findByPriceBetween(minPrice, maxPrice);
        return CarMapper.INSTANCE.mapToDTOs(cars);
    }

    @Override
    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to find car with id: " + id));
        return CarMapper.INSTANCE.mapToDTO(car);
    }

    @Override
    public CarDTO addCar(CarDataDTO carDTO) {
        Car car = CarDataMapper.INSTANCE.mapToEntity(carDTO);
        carRepository.save(car);
        return CarMapper.INSTANCE.mapToDTO(car);
    }

    @Override
    public CarDTO updateCar(Long id, CarDataDTO updatedCarDTO) {
        if (carRepository.existsById(id)) {
            Car car = CarDataMapper.INSTANCE.mapToEntity(updatedCarDTO);
            car.setId(id);
            carRepository.save(car);
            return CarMapper.INSTANCE.mapToDTO(car);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to find car with id: " + id);
    }

    @Override
    public void deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to find car with id: " + id);
        }
    }
}