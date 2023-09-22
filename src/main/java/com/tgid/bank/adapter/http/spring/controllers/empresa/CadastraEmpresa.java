package com.tgid.bank.adapter.http.spring.controllers.empresa;

import com.tgid.bank.adapter.http.spring.dtos.entrada.cliente.CadastraClienteRequest;
import com.tgid.bank.adapter.http.spring.dtos.entrada.empresa.CadastraEmpresaRequest;
import com.tgid.bank.adapter.http.spring.dtos.saida.ResponseData;
import com.tgid.bank.adapter.http.spring.dtos.saida.cliente.CadastraClienteResponse;
import com.tgid.bank.core.port.entrada.cliente.CadastraClientePortIn;
import com.tgid.bank.core.port.entrada.empresa.CadastraEmpresaPortIn;
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
public class CadastraEmpresa {

    @Autowired
    private CadastraEmpresaPortIn empresaService;

    @PostMapping(value = "/empresa")
    @CrossOrigin("*")
    ResponseEntity<?> cadastrarEmpresa(@RequestBody @Valid CadastraEmpresaRequest request){
        empresaService.cadastraEmpresa(request);
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
