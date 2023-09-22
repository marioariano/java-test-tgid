package com.tgid.bank.adapter.http.adapters.saida;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgid.bank.adapter.datastore.entities.Cliente;
import com.tgid.bank.adapter.datastore.entities.Empresa;
import com.tgid.bank.adapter.datastore.entities.Transacao;
import com.tgid.bank.adapter.datastore.repositories.ClienteRepository;
import com.tgid.bank.adapter.datastore.repositories.EmpresaRepository;
import com.tgid.bank.adapter.datastore.repositories.TransacaoRepository;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.biz.TransacaoBusiness;
import com.tgid.bank.core.model.transacao.ResultadoTransacao;
import com.tgid.bank.core.model.transacao.TransacaoModel;
import com.tgid.bank.core.port.entrada.transacao.TransacaoPortIn;
import com.tgid.bank.core.port.saida.transacao.NotificacaoPortOut;
import com.tgid.bank.core.port.saida.transacao.TransacaoPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransacaoAdapter implements TransacaoPortOut {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    TransacaoBusiness transacaoBusiness;

    @Autowired
    NotificacaoPortOut notificacaoPortOut;

    @Override
    public void processaTransacao(TransacaoModel transacaoModel) {

        Cliente cliente = clienteRepository.findByCpf(transacaoModel.getCpf())
                .orElseThrow(() -> new IllegalArgumentException("Cliente inexistente"));
        Empresa empresa = empresaRepository.findByCnpj(transacaoModel.getCnpj())
                .orElseThrow(() -> new IllegalArgumentException("Empresa Inexistente"));
        ResultadoTransacao result = transacaoBusiness.processaTransacao(cliente.getSaldo(),empresa.getSaldo(),empresa.getTaxa(),transacaoModel.getValor(),transacaoModel.getTipoTransacao());
        empresa.setSaldo(result.getSaldoEmpresa());
        empresaRepository.save(empresa);
        cliente.setSaldo(result.getSaldoCliente());
        clienteRepository.save(cliente);
        Transacao transacao = new Transacao(null,empresa,cliente,transacaoModel.getTipoTransacao(),transacaoModel.getValor());
        transacaoRepository.save(transacao);
        notificacaoPortOut.notificaCliente(transacao);
        notificacaoPortOut.notificaEmpresa(transacao);

    }
}
