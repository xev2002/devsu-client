package com.xev.springboot_test_devsu_1_client.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTestUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generarTokenPrueba(Long clientId) {
        return Jwts.builder()
                .claim("clientId", clientId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7200000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}