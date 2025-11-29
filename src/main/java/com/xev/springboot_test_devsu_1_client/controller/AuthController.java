package com.xev.springboot_test_devsu_1_client.controller;

import com.xev.springboot_test_devsu_1_client.model.Cliente;
import com.xev.springboot_test_devsu_1_client.repository.ClienteRepository;
import com.xev.springboot_test_devsu_1_client.security.JwtServiceImpl;
import com.xev.springboot_test_devsu_1_client.security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JwtServiceImpl jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        Long clientId = Long.valueOf(loginData.get("clientId"));
        String contrasena = loginData.get("contrasena");

        Cliente cliente = clienteRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (!cliente.getContrasena().equals(contrasena)) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(clientId);

        return ResponseEntity.ok(Map.of("token", token));
    }
}