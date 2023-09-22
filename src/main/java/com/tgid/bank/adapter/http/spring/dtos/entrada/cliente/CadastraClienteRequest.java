package com.tgid.bank.adapter.http.spring.dtos.entrada.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class CadastraClienteRequest {

    @CPF
    private String cpf;

    @Email
    private String email;

    private String nome;

    private String sobreNome;

    public CadastraClienteRequest(String cpf, String email, String nome, String sobreNome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public CadastraClienteRequest() {
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }
}
