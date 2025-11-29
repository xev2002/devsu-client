package com.xev.springboot_test_devsu_1_client.service;

import com.xev.springboot_test_devsu_1_client.model.Cliente;
import com.xev.springboot_test_devsu_1_client.repository.ClienteRepository;
import com.xev.springboot_test_devsu_1_client.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public String login(Long clientId, String password) {
        Cliente cliente = clienteRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (!cliente.getContrasena().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtService.generateToken(clientId);
    }
}