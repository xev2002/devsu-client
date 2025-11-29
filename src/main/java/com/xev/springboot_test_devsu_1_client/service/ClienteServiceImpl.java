package com.xev.springboot_test_devsu_1_client.service;

import com.xev.springboot_test_devsu_1_client.model.Cliente;
import com.xev.springboot_test_devsu_1_client.model.Genero;
import com.xev.springboot_test_devsu_1_client.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Override
    public void deleteCliente(Long clientId) {
        clienteRepository.deleteById(clientId);
    }
    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente updateCliente(Long clientId, Cliente clienteActualizado) {

        Cliente clienteExistente = clienteRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setGenero(clienteActualizado.getGenero());
        clienteExistente.setEdad(clienteActualizado.getEdad());
        clienteExistente.setDireccion(clienteActualizado.getDireccion());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setClientId(clienteActualizado.getClientId());
        clienteExistente.setContrasena(clienteActualizado.getContrasena());
        clienteExistente.setEstado(clienteActualizado.isEstado());
        return clienteRepository.save(clienteExistente);
    }
    @Override
    public Cliente patchCliente(Long clientId, Map<String, Object> cambios) {
        Cliente cliente = clienteRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cambios.forEach((key, value) -> {
            switch (key) {
                case "nombre" -> cliente.setNombre((String) value);
                case "genero" -> cliente.setGenero(Genero.valueOf((String) value));
                case "edad" -> cliente.setEdad((Integer) value);
                case "direccion" -> cliente.setDireccion((String) value);
                case "telefono" -> cliente.setTelefono((String) value);
                case "clientId" -> cliente.setClientId((Long) value);
                case "contrasena" -> cliente.setContrasena((String) value);
                case "estado" -> cliente.setEstado((Boolean) value);
            }
        });
        return clienteRepository.save(cliente);
    }
}
