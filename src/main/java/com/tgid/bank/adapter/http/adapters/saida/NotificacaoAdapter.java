package com.tgid.bank.adapter.http.adapters.saida;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgid.bank.adapter.datastore.entities.Empresa;
import com.tgid.bank.adapter.datastore.entities.Transacao;
import com.tgid.bank.adapter.datastore.repositories.EmpresaRepository;
import com.tgid.bank.config.ModelMapperConfig;
import com.tgid.bank.core.model.empresa.CadastraEmpresaModel;
import com.tgid.bank.core.port.saida.empresa.EmpresaPortOut;
import com.tgid.bank.core.port.saida.transacao.NotificacaoPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificacaoAdapter implements NotificacaoPortOut {


    @Override
    public void notificaEmpresa(Transacao transacao) {
        // URL do webhook
        String url = "https://webhook.site/8b50c423-697d-48b1-a547-5e4fbdd60ce9";

        // Instanciar o RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Configurar os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Converter o objeto Java para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(transacao);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }

        // Criar a entidade de requisição com o corpo JSON
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Enviar a requisição POST
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        // Obtendo a resposta
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        String responseBody = responseEntity.getBody();
        if(!statusCode.is2xxSuccessful()){
            throw new IllegalArgumentException("Sistema indisponível, não foi possivel comunicar empresa");
        }
    }

    @Override
    public void notificaCliente(Transacao transacao) {
        //TODO: Implementar notificacao email cliente
    }
}
