package com.xev.springboot_test_devsu_1_client.integration;

import com.xev.springboot_test_devsu_1_client.model.Cliente;
import com.xev.springboot_test_devsu_1_client.model.Genero;
import com.xev.springboot_test_devsu_1_client.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class ClienteIntegrationTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void guardarYBuscarCliente() {

        Cliente cliente = new Cliente();
        cliente.setIdentificacion(1001L);
        cliente.setNombre("Juan Perez");
        cliente.setGenero(Genero.MASCULINO);
        cliente.setEdad(30);
        cliente.setDireccion("Calle 123");
        cliente.setTelefono("3001234567");
        cliente.setClientId(1001L);
        cliente.setContrasena("pass123");
        cliente.setEstado(true);

        clienteRepository.save(cliente);

        Cliente encontrado = clienteRepository.findByClientId(1001L).orElse(null);

        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getNombre()).isEqualTo("Juan Perez");
        assertThat(encontrado.getGenero()).isEqualTo(Genero.MASCULINO);
        assertThat(encontrado.getEdad()).isEqualTo(30);
        assertThat(encontrado.getClientId()).isEqualTo(1001L);
        assertThat(encontrado.getContrasena()).isEqualTo("pass123");
        assertThat(encontrado.isEstado()).isTrue();
    }
}