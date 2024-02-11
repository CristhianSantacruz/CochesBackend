package com.klashz.api.coches.persistence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter @Setter
@Entity
@Table(name = "coches")
public class CochesEntity {
    @Id
    private Long codigo_coche;
}
