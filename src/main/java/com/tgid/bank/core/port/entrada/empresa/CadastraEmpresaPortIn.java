package com.tgid.bank.core.port.entrada.empresa;

import com.tgid.bank.adapter.http.spring.dtos.entrada.cliente.CadastraClienteRequest;
import com.tgid.bank.adapter.http.spring.dtos.entrada.empresa.CadastraEmpresaRequest;

public interface CadastraEmpresaPortIn {

    void cadastraEmpresa(CadastraEmpresaRequest cadastraEmpresaRequest);
}
