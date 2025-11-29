package com.xev.springboot_test_devsu_1_client.controller;

import com.xev.springboot_test_devsu_1_client.model.Cliente;
import com.xev.springboot_test_devsu_1_client.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.saveCliente(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        clienteService.deleteCliente(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<>(clienteService.findAllClientes(), HttpStatus.OK);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<?> updateClient(@PathVariable Long clientId, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteService.updateCliente(clientId, clienteActualizado);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PatchMapping("{clientId}")
    public ResponseEntity<?> patchCliente(@PathVariable Long clientId, @RequestBody Map<String, Object> cambios) {
        Cliente cliente = clienteService.patchCliente(clientId, cambios);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
