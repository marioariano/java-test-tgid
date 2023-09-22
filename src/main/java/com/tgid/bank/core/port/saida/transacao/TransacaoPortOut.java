package com.tgid.bank.core.port.saida.transacao;

import com.tgid.bank.core.model.transacao.TransacaoModel;

public interface TransacaoPortOut {

    void processaTransacao(TransacaoModel transacaoModel);
}
