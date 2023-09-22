package com.tgid.bank.adapter.http.spring.controllers.cliente;

import com.tgid.bank.adapter.http.spring.dtos.entrada.cliente.CadastraClienteRequest;
import com.tgid.bank.adapter.http.spring.dtos.saida.ResponseData;
import com.tgid.bank.adapter.http.spring.dtos.saida.cliente.CadastraClienteResponse;
import com.tgid.bank.core.port.entrada.cliente.CadastraClientePortIn;
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
public class CadastraCliente {

    @Autowired
    private CadastraClientePortIn clienteService;

    @PostMapping(value = "/cliente")
    @CrossOrigin("*")
    ResponseEntity<?> cadastrarCliente(@RequestBody @Valid CadastraClienteRequest request){
        clienteService.cadastraCliente(request);
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
