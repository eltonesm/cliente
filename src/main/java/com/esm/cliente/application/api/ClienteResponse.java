package com.esm.cliente.application.api;

import com.esm.cliente.domain.Cliente;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ClienteResponse {
    private UUID idCliente;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
    }
}
