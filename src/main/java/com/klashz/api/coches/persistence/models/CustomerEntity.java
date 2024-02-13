package com.klashz.api.coches.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class CustomerEntity {

    @Id
    @Column(name = "cedula")
    private String carId;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "correo")
    private String email;

    @Column(name = "nombre_completo")
    private String  fullName;

    @Column(name = "numero_celular")
    private String  phone;

    @Column(name = "contrasenia")
    private String password;

    @Column(name = "rol")
    private String rol;
}
