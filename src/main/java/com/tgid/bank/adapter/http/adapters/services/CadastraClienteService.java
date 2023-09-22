package com.tgid.bank.adapter.http.adapters.services;

import com.tgid.bank.adapter.http.adapters.saida.ClienteAdapter;
import com.tgid.bank.adapter.http.spring.dtos.entrada.cliente.CadastraClienteRequest;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.model.cliente.CadastraClienteModel;
import com.tgid.bank.core.port.entrada.cliente.CadastraClientePortIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraClienteService implements CadastraClientePortIn {

    @Autowired
    ClienteAdapter cadastraClienteAdapter;

    @Autowired
    private ModelMapperConfig m;

    @Override
    public void cadastraCliente(CadastraClienteRequest cadastraClienteRequest) {
        cadastraClienteAdapter.registraCliente(m.modelMapper().map(cadastraClienteRequest, CadastraClienteModel.class));
    }
}
