package com.xev.springboot_test_devsu_1_client.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Persona {
    @Id
    @Column(name = "identificacion", nullable = false, unique = true)
    private Long identificacion;
    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;
    @Enumerated(EnumType.STRING)
    @Column(name="genero", nullable = false)
    private Genero genero;
    @Column(name="edad", nullable = false)
    private int edad;
    @Column(name="direccion", nullable = false, length = 200)
    private String direccion;
    @Column(name="telefono", nullable = false, length = 12)
    private String telefono;
}
