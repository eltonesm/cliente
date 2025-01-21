package com.esm.cliente.infra;

import com.esm.cliente.application.repository.ClienteRepository;
import com.esm.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
