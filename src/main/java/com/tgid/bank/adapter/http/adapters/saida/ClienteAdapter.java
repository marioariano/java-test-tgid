package com.tgid.bank.adapter.http.adapters.saida;

import com.tgid.bank.adapter.datastore.entities.Cliente;
import com.tgid.bank.adapter.datastore.repositories.ClienteRepository;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.model.cliente.CadastraClienteModel;
import com.tgid.bank.core.port.saida.cliente.ClientePortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteAdapter implements ClientePortOut {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ModelMapperConfig m;

    @Override
    public void registraCliente(CadastraClienteModel cadastraClienteModel) {
        clienteRepository.save(m.modelMapper().map(cadastraClienteModel, Cliente.class));
    }
}
