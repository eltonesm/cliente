package com.esm.cliente.domain;

import com.esm.cliente.application.api.ClienteAlteracaoRequest;
import com.esm.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente", schema = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private UUID idCliente;
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.cpf = clienteRequest.getCpf();
        this.telefone = clienteRequest.getTelefone();
    }

    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nome = clienteAlteracaoRequest.getNome();
        this.cpf = clienteAlteracaoRequest.getCpf();
        this.telefone = clienteAlteracaoRequest.getTelefone();
    }
}
