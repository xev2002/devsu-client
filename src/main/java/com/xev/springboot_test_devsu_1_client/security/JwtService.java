package com.xev.springboot_test_devsu_1_client.security;

import io.jsonwebtoken.Claims;

import java.security.Key;

public interface JwtService {
    String generateToken(Long clientId);
}
