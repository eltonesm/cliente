package com.esm.cliente.application.api;

import com.esm.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[Start]BeneficiarioController - postBeneficiario");
        ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
        log.info("[Finish]BeneficiarioController - postBeneficiario");
        return clienteCriado;
    }

    @Override
    public List<ClienteListResponse> clienteListResponse() {
        log.info("[start] ClienteController - clienteListResponse");
        List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
        log.debug("[finish] ClienteController - clienteListResponse");
        return clientes;
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("[start] ClienteController - buscaClientePorId");
        ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientePorId(idCliente);
        log.debug("[finish] ClienteController - buscaClientePorId");
        return clienteDetalhado;
    }

    @Override
    public void editaCliente(ClienteAlteracaoRequest clienteAlteracaoRequest, UUID idCliente) {
        log.info("[start] ClienteController - editaCliente");
        clienteService.editaCliente(clienteAlteracaoRequest, idCliente);
        log.debug("[finish] ClienteController - editaCliente");
    }

    @Override
    public void deletaCliente(UUID idCliente) {
        log.info("[start] ClienteController - deletaCliente");
        clienteService.deletaCliente(idCliente);
        log.debug("[finish] ClienteController - deletaCliente");
    }
}
