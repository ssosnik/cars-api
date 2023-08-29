package com.selvita.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private Long productionYear;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "color")
    private String color;

}
