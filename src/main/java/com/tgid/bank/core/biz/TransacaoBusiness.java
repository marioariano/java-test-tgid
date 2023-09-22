package com.tgid.bank.core.biz;

import com.tgid.bank.adapter.datastore.entities.enums.TipoTransacao;
import com.tgid.bank.core.model.transacao.ResultadoTransacao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransacaoBusiness {

    @Deprecated
    public TransacaoBusiness() {
    }

    public ResultadoTransacao processaTransacao(BigDecimal saldoCliente, BigDecimal saldoEmpresa, BigDecimal taxaEmpresa, BigDecimal valorTransacao, TipoTransacao tipoTransacao){
        BigDecimal saldoClienteFinal = BigDecimal.ZERO;
        BigDecimal saldoEmpresaFinal = BigDecimal.ZERO;

        if(tipoTransacao.equals(TipoTransacao.DEPOSITO)){
            int diff = saldoCliente.compareTo(valorTransacao);
            if(diff<0){
                throw new IllegalArgumentException("Saldo insuficiente, o saldo cliente é de: "+ saldoCliente.floatValue() +" e o valor da transação: " + valorTransacao.floatValue());
            }
            saldoClienteFinal = saldoCliente.subtract(valorTransacao).subtract(taxaEmpresa);
            saldoEmpresaFinal = saldoEmpresa.add(valorTransacao).subtract(taxaEmpresa);
        }
        else
        {
            int diff = saldoEmpresa.compareTo(valorTransacao);
            if(diff<0){
                throw new IllegalArgumentException("Saldo insuficiente, o saldo da empresa é de: "+ saldoEmpresa.floatValue() +" e o valor da transação: " + valorTransacao.floatValue());
            }
            saldoClienteFinal = saldoEmpresa.subtract(valorTransacao).subtract(taxaEmpresa);
            saldoEmpresaFinal = saldoCliente.add(valorTransacao).subtract(taxaEmpresa);
        }

        return new ResultadoTransacao(saldoClienteFinal,saldoEmpresaFinal);


    }




}
