package com.klashz.api.coches.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.ValueExp;

@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantityCars;
    @Column(name = "total")
    private Double totalPriceCars;

    @ManyToOne()
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura",insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @MapsId(value="codeCar")
    @JoinColumn(name="coches_codigo_coche",insertable = false,updatable = false)
    private CarEntity carEntity;
}
