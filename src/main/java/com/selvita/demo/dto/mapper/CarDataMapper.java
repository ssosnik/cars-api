package com.selvita.demo.dto.mapper;

import com.selvita.demo.domain.Car;
import com.selvita.demo.dto.CarDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarDataMapper {

    CarDataMapper INSTANCE = Mappers.getMapper(CarDataMapper.class);

    Car mapToEntity(CarDataDTO carDataDTO);

    CarDataDTO mapToDTO(Car car);

    List<CarDataDTO> mapToDTOs(List<Car> cars);
}