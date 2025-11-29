package com.xev.springboot_test_devsu_1_client.repository;

import com.xev.springboot_test_devsu_1_client.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByClientId(Long clientId);
}
