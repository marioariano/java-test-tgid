package com.tgid.bank.core.port.entrada.cliente;

import com.tgid.bank.adapter.http.spring.dtos.entrada.cliente.CadastraClienteRequest;

public interface CadastraClientePortIn {

    void cadastraCliente(CadastraClienteRequest cadastraClienteRequest);
}
