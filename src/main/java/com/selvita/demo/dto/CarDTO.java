package com.selvita.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
//@Builder
@NoArgsConstructor
public class CarDTO {

    private Long id;
    private String brandName;
    private String model;
    private Long productionYear;
    private BigDecimal price;
    private String color;
}