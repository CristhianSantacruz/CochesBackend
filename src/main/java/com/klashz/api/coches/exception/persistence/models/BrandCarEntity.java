package com.klashz.api.coches.exception.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "marca_coche")
public class BrandCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "brandCarEntity", orphanRemoval = true)
    private List<CarEntity> carEntities;

}
