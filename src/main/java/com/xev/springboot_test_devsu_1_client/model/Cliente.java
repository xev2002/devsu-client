package com.xev.springboot_test_devsu_1_client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente extends Persona{

    @Column(name = "client_Id", unique = true, nullable = false)
    private Long clientId;
    @Column(name="contrasena", nullable = false)
    private String contrasena;
    @Column(name="estado", nullable = false)
    private boolean estado;
}
