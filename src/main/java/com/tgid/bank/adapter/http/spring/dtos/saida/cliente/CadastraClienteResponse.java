package com.tgid.bank.adapter.http.spring.dtos.saida.cliente;

public class CadastraClienteResponse {

    private String message;

    public CadastraClienteResponse(String message) {
        this.message = message;
    }
    @Deprecated
    public CadastraClienteResponse() {
    }

    public String getMessage() {
        return message;
    }
}
