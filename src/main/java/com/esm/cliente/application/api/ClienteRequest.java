package com.esm.cliente.application.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteRequest {
    private String nome;
    private String cpf;
    private String telefone;

}
