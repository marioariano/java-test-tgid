package com.tgid.bank.adapter.http.adapters.services;

import com.tgid.bank.adapter.http.adapters.saida.TransacaoAdapter;
import com.tgid.bank.adapter.http.spring.dtos.entrada.transacao.TransacaoRequest;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.model.transacao.TransacaoModel;
import com.tgid.bank.core.port.entrada.transacao.TransacaoPortIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements TransacaoPortIn {

    @Autowired
    TransacaoAdapter transacaoAdapter;

    @Autowired
    private ModelMapperConfig m;

    @Override
    public void processaTransacao(TransacaoRequest transacaoRequest) {
        transacaoAdapter.processaTransacao(m.modelMapper().map(transacaoRequest, TransacaoModel.class));
    }
}
