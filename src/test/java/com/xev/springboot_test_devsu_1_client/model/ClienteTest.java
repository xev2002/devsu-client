package com.xev.springboot_test_devsu_1_client.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClienteTest {

    @Test
    void testClienteSettersAndGetters() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Perez");
        cliente.setGenero(Genero.MASCULINO);
        cliente.setEdad(30);
        cliente.setIdentificacion(12345678L);
        cliente.setDireccion("Calle 123");
        cliente.setTelefono("987654321");
        cliente.setClientId(1001L);
        cliente.setContrasena("secreta123");
        cliente.setEstado(true);

        assertThat(cliente.getNombre()).isEqualTo("Juan Perez");
        assertThat(cliente.getGenero()).isEqualTo(Genero.MASCULINO);
        assertThat(cliente.getEdad()).isEqualTo(30);
        assertThat(cliente.getIdentificacion()).isEqualTo(12345678L);
        assertThat(cliente.getDireccion()).isEqualTo("Calle 123");
        assertThat(cliente.getTelefono()).isEqualTo("987654321");
        assertThat(cliente.getClientId()).isEqualTo(1001L);
        assertThat(cliente.getContrasena()).isEqualTo("secreta123");
        assertThat(cliente.isEstado()).isTrue();
    }

    @Test
    void testEqualsAndHashCode() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setClientId(1001L);
        c2.setClientId(1001L);

        assertThat(c1).isEqualTo(c2);
        assertThat(c1.hashCode()).isEqualTo(c2.hashCode());
    }

    @Test
    void testNotEqualsWhenIdsDiffer() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setClientId(1001L);
        c2.setClientId(2002L);

        assertThat(c1).isNotEqualTo(c2);
    }

    @Test
    void testEstado() {
        Cliente cliente = new Cliente();
        cliente.setEstado(false);
        assertThat(cliente.isEstado()).isFalse();
        cliente.setEstado(true);
        assertThat(cliente.isEstado()).isTrue();
    }

    @Test
    void testPasswordNotNull() {
        Cliente cliente = new Cliente();
        cliente.setContrasena("clave123");
        assertThat(cliente.getContrasena()).isNotNull()
                .isEqualTo("clave123");
    }
}