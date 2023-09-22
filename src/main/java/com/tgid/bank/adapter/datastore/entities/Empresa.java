package com.tgid.bank.adapter.datastore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true)
    private UUID id;

    @Column(unique = true,columnDefinition="VARCHAR(14)")
    private String cnpj;

    private String nomeFantasia;

    private BigDecimal taxa;

    private BigDecimal saldo;

    public Empresa(UUID id, String cnpj, String nomeFantasia, BigDecimal taxa, BigDecimal saldo) {
        this.id = id;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.taxa = taxa;
        this.saldo = saldo;
    }

    @Deprecated
    public Empresa() {
    }

    public UUID getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
