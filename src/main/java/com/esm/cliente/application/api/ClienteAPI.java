package com.esm.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cliente")
public interface ClienteAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente(@RequestBody ClienteRequest clienteRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> clienteListResponse();

    @GetMapping("/{idCliente}")
    @ResponseStatus(value = HttpStatus.OK)
    ClienteDetalhadoResponse buscaClientePorId(@PathVariable UUID idCliente);

    @PatchMapping("/edita-cliente")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void editaCliente(@RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest,
                      @RequestParam(value = "idCliente") UUID idCliente);

    @DeleteMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaCliente(@PathVariable UUID idCliente);
}
