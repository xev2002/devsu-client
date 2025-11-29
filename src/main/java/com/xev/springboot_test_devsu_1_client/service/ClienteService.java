package com.xev.springboot_test_devsu_1_client.service;

import com.xev.springboot_test_devsu_1_client.model.Cliente;

import java.util.List;
import java.util.Map;

public interface ClienteService {
    Cliente saveCliente(Cliente cliente);

    void deleteCliente(Long clientId);

    List<Cliente> findAllClientes();

    Cliente updateCliente(Long clientId, Cliente clienteActualizado);

    Cliente patchCliente(Long identificacion, Map<String, Object> cambios);
}
