package com.klashz.api.coches.exception.persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CarPurchasePK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Column(name = "compras_numero_factura")
    private Long purchaseNumberBill;

    @Column(name="coches_codigo_coche")
    private Long codeCar;
}
