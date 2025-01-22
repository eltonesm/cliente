package com.esm.cliente.application.service;

import com.esm.cliente.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    void editaCliente(ClienteAlteracaoRequest clienteAlteracaoRequest, UUID idCliente);

    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);
}
