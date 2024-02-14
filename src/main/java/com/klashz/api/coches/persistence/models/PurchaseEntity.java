package com.klashz.api.coches.persistence.models;

import com.klashz.api.coches.domain.dto.purchases.CarPurchaseRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura", nullable = false)
    private Long numberBill;
    @Column(name = "cliente_cedula")
    private String cardId;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    @Column(name = "medio_pago")
    private String paymentMethod;
    @Column(name = "total")
    private Double total;


    @OneToMany(mappedBy = "purchaseEntity",cascade = CascadeType.ALL)
    private List<CarPurchaseEntity> carPurchases;

    @ManyToOne()
    @JoinColumn(name = "cliente_cedula",insertable = false,updatable = false )
    private CustomerEntity customerEntity;

}