package com.esm.cliente.application.service;

import com.esm.cliente.application.api.ClienteRequest;
import com.esm.cliente.application.repository.ClienteRepository;
import com.esm.cliente.domain.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteApplicationServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteApplicationService clienteApplicationService;

    @Test
    @DisplayName("Deve criar um Clinente com sucesso")
    void devecriarClienteComSucesso() {

        //DADO - GIVEN
        ClienteRequest clienteRequest = DataHelper.clienteRequest();
        Cliente cliente = new Cliente(clienteRequest);

        //QUANDO - WHEN
        when(clienteRepository.salva(any(Cliente.class))).thenReturn(cliente);

        clienteApplicationService.criaCliente(clienteRequest);

        //ENTAO - THEN
        verify(clienteRepository, times(0)).salva(any(Cliente.class));

    }
}