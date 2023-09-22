package com.tgid.bank.adapter.datastore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true)
    private UUID id;

    @Column(unique = true,columnDefinition="VARCHAR(11)")
    private String cpf;

    @Column(unique = true)
    private String email;

    private String nome;

    private String sobreNome;

    private BigDecimal saldo;

    public Cliente(UUID id, String cpf, String email, String nome, String sobreNome, BigDecimal saldo) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.saldo = saldo;
    }

    @Deprecated
    public Cliente() {
    }

    public UUID getId() {
        return id;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
