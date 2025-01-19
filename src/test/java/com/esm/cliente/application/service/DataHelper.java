package com.esm.cliente.application.service;

import com.esm.cliente.application.api.ClienteRequest;
import com.esm.cliente.domain.Cliente;

public class DataHelper {

    public static Cliente criaCliente() {
        return new Cliente(clienteRequest());
    }

    // Método para criar uma instância de ClienteRequest
    public static ClienteRequest clienteRequest() {
        return new ClienteRequest(
                "Elton",
                "83885897504",
                "9999999999");
    }
}
