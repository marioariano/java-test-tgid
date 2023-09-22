package com.tgid.bank.adapter.http.adapters.saida;

import com.tgid.bank.adapter.datastore.entities.Empresa;
import com.tgid.bank.adapter.datastore.repositories.EmpresaRepository;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.model.empresa.CadastraEmpresaModel;
import com.tgid.bank.core.port.saida.empresa.EmpresaPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpresaAdapter implements EmpresaPortOut {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapperConfig m;

    @Override
    public void registraEmpresa(CadastraEmpresaModel cadastraEmpresaModel) {
        empresaRepository.save(m.modelMapper().map(cadastraEmpresaModel, Empresa.class));
    }
}
