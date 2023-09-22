package com.tgid.bank.adapter.http.spring.dtos.entrada.transacao;

import com.tgid.bank.adapter.datastore.entities.enums.TipoTransacao;

import java.math.BigDecimal;

public class TransacaoRequest {

    private String cpf;

    private String cnpj;

    private BigDecimal valor;

    private TipoTransacao tipoTransacao;

    public TransacaoRequest(String cpf, String cnpj, BigDecimal valor, TipoTransacao tipoTransacao) {
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public TransacaoRequest() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
