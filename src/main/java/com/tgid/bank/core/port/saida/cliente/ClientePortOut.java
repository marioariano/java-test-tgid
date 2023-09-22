package com.tgid.bank.core.port.saida.cliente;


import com.tgid.bank.core.model.cliente.CadastraClienteModel;

public interface ClientePortOut {

    void registraCliente(CadastraClienteModel cadastraClienteModel);
}
