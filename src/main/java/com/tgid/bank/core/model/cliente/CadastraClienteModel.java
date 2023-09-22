package com.tgid.bank.core.model.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class CadastraClienteModel {
    private String cpf;

    private String email;

    private String nome;

    private String sobreNome;

    private BigDecimal saldo = BigDecimal.ZERO;

    public CadastraClienteModel(String cpf, String email, String nome, String sobreNome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.saldo = BigDecimal.ZERO;
    }

    @Deprecated
    public CadastraClienteModel() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
