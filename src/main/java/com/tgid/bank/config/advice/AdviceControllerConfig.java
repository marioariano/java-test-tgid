package com.tgid.bank.config.advice;

import com.tgid.bank.adapter.http.spring.dtos.saida.Response;
import com.tgid.bank.adapter.http.spring.dtos.saida.handle.ErrorApiResponse;
import com.tgid.bank.core.exceptions.HttpException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import java.time.LocalDateTime;

@ControllerAdvice
public class AdviceControllerConfig extends ResponseEntityExceptionHandler {

    private final HttpServletRequest request;

    public AdviceControllerConfig(HttpServletRequest request) {
        this.request = request;
    }

    //Tratamento de internal server erros


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode httpStatus, WebRequest request) {
        if(HttpStatus.INTERNAL_SERVER_ERROR.equals(httpStatus))request.setAttribute("javax.servlet.error.exception",ex,0);
        var response = buildErrorApiResponse(ex.getMessage(),ex.getLocalizedMessage(),HttpStatus.valueOf(httpStatus.value()),null);
        return ResponseEntity.status(httpStatus).body(new Response<>(response));
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleHttpExceptions(HttpException throwable){
        var response = buildErrorApiResponse(throwable.getMessage(),throwable.getHttpStatus().getReasonPhrase(),throwable.getHttpStatus(),null);
        return ResponseEntity.status(throwable.getHttpStatus()).body(new Response<>(response));
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleMessagingException(MessagingException throwable){
        var response = buildErrorApiResponse(throwable.getMessage(),throwable.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,throwable.getCause().getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(response));
    }

    //Tratamento default para erros
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Throwable throwable){
        var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        var errorApiResponse = buildErrorApiResponse(throwable.getMessage(),httpStatus.getReasonPhrase(),httpStatus,null);
        return ResponseEntity.status(httpStatus).body(errorApiResponse);
    }

    ErrorApiResponse buildErrorApiResponse(String message, String phrase, HttpStatus httpStatus, String details){
        return new ErrorApiResponse(LocalDateTime.now().toString(),httpStatus.toString(),message,details,null,httpStatus.toString(),getPathUri());
    }

    private String getPathUri(){
        return getFullRouteRequest();
    }

    public String getVerbMethodRequest(){
        return request.getMethod();
    }

    public String pathRequestUri(){
        return request.getRequestURI().substring(request.getContextPath().length());
    }

    public String getFullRouteRequest(){
        return "{".concat(getVerbMethodRequest().concat("}")).concat(pathRequestUri());
    }
}