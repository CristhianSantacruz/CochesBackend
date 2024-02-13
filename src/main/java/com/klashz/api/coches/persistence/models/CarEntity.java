package com.klashz.api.coches.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coches")
@Getter @Setter
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche", nullable = false)
    private Long serial;
    @Column(name = "marca_coche_id")
    private Long branCardId;
    @Column(name = "referencia")
    private String reference;
    @Column(name = "precio")
    private Double price;
    @Column(name = "anio_modelo")
    private Double yearModel;
    @Column(name = "color")
    private String color;
    @Column(name = "numero_caballos_fuerza")
    private Double horsePower;
    @Column(name = "cantidad_puertas")
    private Integer numberDoor;
    @Column(name = "cilindraje")
    private Double engineDisplacement;
    @Column(name = "transmision")
    private String transmission;
    @Column(name = "tipo_combustible")
    private String fuelType;
    @Column(name = "cantidad_asientos")
    private Integer numberSeats;
    @Column(name = "traccion")
    private Integer traction;
    @Column(name = "direccion")
    private String steering;
    @Column(name = "categoria")
    private String category;
    @Column(name = "ruta_imagen")
    private String pathImage;
    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id",insertable = false,updatable = false)
    private BrandCarEntity brandCarEntity;

}
