package com.esm.cliente.application.service;

import com.esm.cliente.application.api.ClienteRequest;
import com.esm.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
}
