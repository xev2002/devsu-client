package com.xev.springboot_test_devsu_1_client.security;

import lombok.Data;

@Data
public class LoginRequest {
    private Long clientId;
    private String contrasena;
}
