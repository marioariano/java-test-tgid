package com.tgid.bank.adapter.http.spring.controllers.transacao;

import com.tgid.bank.adapter.http.spring.dtos.entrada.empresa.CadastraEmpresaRequest;
import com.tgid.bank.adapter.http.spring.dtos.entrada.transacao.TransacaoRequest;
import com.tgid.bank.adapter.http.spring.dtos.saida.ResponseData;
import com.tgid.bank.adapter.http.spring.dtos.saida.cliente.CadastraClienteResponse;
import com.tgid.bank.core.port.entrada.empresa.CadastraEmpresaPortIn;
import com.tgid.bank.core.port.entrada.transacao.TransacaoPortIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class Transacao {

    @Autowired
    private TransacaoPortIn transacaoService;

    @PostMapping(value = "/transacao")
    @CrossOrigin("*")
    ResponseEntity<?> cadastrarEmpresa(@RequestBody @Valid TransacaoRequest request){
        transacaoService.processaTransacao(request);
        return getResponseData(buildResponseData(buildCadastraClienteResponse()), HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    public CadastraClienteResponse buildCadastraClienteResponse(){
        return new CadastraClienteResponse("PROCESSAMENTO OK");
    }

    private ResponseData buildResponseData(CadastraClienteResponse cadastraClienteResponse){
        return new ResponseData(Collections.singletonList(cadastraClienteResponse));
    }
}
