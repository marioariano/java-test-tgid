package com.tgid.bank.core.port.saida.transacao;

import com.tgid.bank.adapter.datastore.entities.Transacao;

public interface NotificacaoPortOut {

    void notificaEmpresa (Transacao transacao);

    void notificaCliente (Transacao transacao);
}
