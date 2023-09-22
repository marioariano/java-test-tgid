package com.tgid.bank.core.port.entrada.transacao;

import com.tgid.bank.adapter.http.spring.dtos.entrada.transacao.TransacaoRequest;

public interface TransacaoPortIn {

    void processaTransacao(TransacaoRequest transacaoRequest);
}
