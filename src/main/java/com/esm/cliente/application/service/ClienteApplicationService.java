package com.esm.cliente.application.service;

import com.esm.cliente.application.api.ClienteRequest;
import com.esm.cliente.application.api.ClienteResponse;
import com.esm.cliente.application.repository.ClienteRepository;
import com.esm.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
