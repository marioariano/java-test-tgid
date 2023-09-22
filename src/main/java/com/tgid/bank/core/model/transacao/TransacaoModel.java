package com.tgid.bank.core.model.transacao;

import com.tgid.bank.adapter.datastore.entities.enums.TipoTransacao;

import java.math.BigDecimal;

public class TransacaoModel {

    private String cpf;

    private String cnpj;

    private BigDecimal valor;

    private TipoTransacao tipoTransacao;

    public TransacaoModel(String cpf, String cnpj, BigDecimal valor, TipoTransacao tipoTransacao) {
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public TransacaoModel() {
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
