package com.digital.dti.tasks.app.domain.exceptionHandler;

import com.digital.dti.tasks.app.domain.exceptionHandler.exceptions.EntidadeNaoEncontradaException;
import com.digital.dti.tasks.app.domain.exceptionHandler.message.Erro;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex,
                                                              WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        Erro erro = new Erro(status.value(), OffsetDateTime.now(), ex.getMessage(), null);
        return super.handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
    }


}
