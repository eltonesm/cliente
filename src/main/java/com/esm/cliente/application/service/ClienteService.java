package com.esm.cliente.application.service;

import com.esm.cliente.application.api.ClienteListResponse;
import com.esm.cliente.application.api.ClienteRequest;
import com.esm.cliente.application.api.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
    List<ClienteListResponse> buscaTodosClientes();
}
