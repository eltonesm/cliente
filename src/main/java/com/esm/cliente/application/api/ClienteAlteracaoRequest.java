package com.esm.cliente.application.api;

import lombok.Getter;

@Getter
public class ClienteAlteracaoRequest {
    private String nome;
    private String cpf;
    private String telefone;
}
