package com.klashz.api.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Dto  del Model Coche
 */
@Getter
@Setter
@ToString
public class CarDto {

    private Long serial;
    private Long branCardId;
    private String brandCarEntity; // nuevo atributo
    private String reference;
    private Double price;
    private Double yearModel;
    private String color;
    private Double horsePower;
    private Integer numberDoor;
    private Double engineDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeats;
    private Integer traction;
    private String steering;
    private String category;
    private String pathImage;
    private Integer stock;

}
