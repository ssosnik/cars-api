package com.selvita.demo.dto.mapper;

import com.selvita.demo.domain.Car;
import com.selvita.demo.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "id", ignore = true) // Ignore id during mapping
    Car mapToEntity(CarDTO carDTO);

    CarDTO mapToDTO(Car car);

    List<CarDTO> mapToDTOs(List<Car> cars);
}