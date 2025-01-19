package com.esm.cliente.infra;

import com.esm.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteSpringJPARepository extends JpaRepository<Cliente, UUID> {
}
