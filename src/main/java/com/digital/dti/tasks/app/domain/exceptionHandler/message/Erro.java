package com.digital.dti.tasks.app.domain.exceptionHandler.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Erro {

    private Integer status;
    private OffsetDateTime data;
    private String message;

}
