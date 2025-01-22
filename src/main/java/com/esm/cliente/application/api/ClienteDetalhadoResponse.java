package com.esm.cliente.application.api;

import com.esm.cliente.domain.Cliente;
import lombok.Getter;

@Getter
public class ClienteDetalhadoResponse {

    private String nome;
    private String telefone;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
    }
}
