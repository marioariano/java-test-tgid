package com.tgid.bank.adapter.datastore.entities;

import com.tgid.bank.adapter.datastore.entities.enums.TipoTransacao;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true)
    private UUID id;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Cliente cliente;

    private TipoTransacao tipo;

    private BigDecimal valor;

    private LocalDateTime dataHoraTransacao = LocalDateTime.now();

    public Transacao(UUID id, Empresa empresa, Cliente cliente, TipoTransacao tipo, BigDecimal valor) {
        this.id = id;
        this.empresa = empresa;
        this.cliente = cliente;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHoraTransacao = LocalDateTime.now();
    }

    @Deprecated
    public Transacao() {
    }

    public UUID getId() {
        return id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
