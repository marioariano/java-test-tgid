package com.tgid.bank.core.model.transacao;

import java.math.BigDecimal;

public class ResultadoTransacao {

    private BigDecimal saldoCliente;

    private BigDecimal saldoEmpresa;

    public ResultadoTransacao(BigDecimal saldoCliente, BigDecimal saldoEmpresa) {
        this.saldoCliente = saldoCliente;
        this.saldoEmpresa = saldoEmpresa;
    }

    public ResultadoTransacao() {
    }

    public BigDecimal getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(BigDecimal saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public BigDecimal getSaldoEmpresa() {
        return saldoEmpresa;
    }

    public void setSaldoEmpresa(BigDecimal saldoEmpresa) {
        this.saldoEmpresa = saldoEmpresa;
    }
}
