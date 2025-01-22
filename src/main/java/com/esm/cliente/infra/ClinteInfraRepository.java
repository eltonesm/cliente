package com.esm.cliente.infra;

import com.esm.cliente.application.repository.ClienteRepository;
import com.esm.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClinteInfraRepository implements ClienteRepository {

    private final ClienteSpringJPARepository clienteSpringJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[start] ClinteInfraRepository - salva");
        try {
            clienteSpringJPARepository.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro inesperado ao salvar cliente: {}");
        }

        log.info("[finish] ClinteInfraRepository - salva");
        return cliente;
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        log.info("[start] ClinteInfraRepository - buscaTodosClientes");
        List<Cliente> todosClientes = clienteSpringJPARepository.findAll();
        log.debug("[finish] ClinteInfraRepository - buscaTodosClientes");
        return todosClientes;
    }

    @Override
    public Cliente buscaClientePorId(UUID idCliente) {
        log.info("[start] ClinteInfraRepository - buscaClientePorId");
        Cliente cliente = clienteSpringJPARepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + idCliente));
        log.debug("[finish] ClinteInfraRepository - buscaClientePorId");
        return cliente;
    }
}
