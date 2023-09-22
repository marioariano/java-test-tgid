package com.tgid.bank.adapter.http.spring.dtos.entrada.empresa;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

public class CadastraEmpresaRequest {

    @CNPJ
    private String cnpj;

    @NotEmpty
    private String nomeFantasia;

    private BigDecimal taxa;

    public CadastraEmpresaRequest(String cnpj, String nomeFantasia, BigDecimal taxa) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.taxa = taxa;
    }

    @Deprecated
    public CadastraEmpresaRequest() {
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
}
