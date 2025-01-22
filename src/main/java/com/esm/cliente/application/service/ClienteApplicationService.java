package com.esm.cliente.application.service;

import com.esm.cliente.application.api.*;
import com.esm.cliente.application.repository.ClienteRepository;
import com.esm.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - criaCliente");
        Cliente clienteCriado = new Cliente(clienteRequest);
        clienteRepository.salva(clienteCriado);
        log.info("[finish] ClienteApplicationService - criaCliente");
        return new ClienteResponse(clienteCriado);
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] ClienteApplicationService - buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        log.debug("[finish] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaClientePorId");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        log.debug("[finish] ClienteApplicationService - buscaClientePorId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void editaCliente(ClienteAlteracaoRequest clienteAlteracaoRequest, UUID idCliente) {
        log.info("[start] ClienteApplicationService - editaCliente");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.salva(cliente);
        log.debug("[finish] ClienteApplicationService - editaCliente");
    }
}
