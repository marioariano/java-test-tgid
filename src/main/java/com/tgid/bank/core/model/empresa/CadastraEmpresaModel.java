package com.tgid.bank.core.model.empresa;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class CadastraEmpresaModel {

    private String cnpj;

    private String nomeFantasia;

    private BigDecimal taxa;

    private BigDecimal saldo = BigDecimal.ZERO;

    public CadastraEmpresaModel(String cnpj, String nomeFantasia, BigDecimal taxa, BigDecimal saldo) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.taxa = taxa;
        this.saldo = saldo;
    }

    @Deprecated
    public CadastraEmpresaModel() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
