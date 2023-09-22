package com.tgid.bank.adapter.http.adapters.services;

import com.tgid.bank.adapter.http.adapters.saida.EmpresaAdapter;
import com.tgid.bank.adapter.http.spring.dtos.entrada.empresa.CadastraEmpresaRequest;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.model.empresa.CadastraEmpresaModel;
import com.tgid.bank.core.port.entrada.empresa.CadastraEmpresaPortIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraEmpresaService implements CadastraEmpresaPortIn {

    @Autowired
    EmpresaAdapter empresaAdapter;

    @Autowired
    private ModelMapperConfig m;
    @Override
    public void cadastraEmpresa(CadastraEmpresaRequest cadastraEmpresaRequest) {
        empresaAdapter.registraEmpresa(m.modelMapper().map(cadastraEmpresaRequest, CadastraEmpresaModel.class));
    }
}
