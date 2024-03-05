package com.klashz.api.coches.exception.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private double total;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne()
    //@MapsId(value="codeCard")
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;

}
