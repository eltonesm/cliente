package com.esm.cliente.application.repository;

import com.esm.cliente.application.api.ClienteAlteracaoRequest;
import com.esm.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);

    List<Cliente> buscaTodosClientes();

    Cliente buscaClientePorId(UUID idCliente);
}
