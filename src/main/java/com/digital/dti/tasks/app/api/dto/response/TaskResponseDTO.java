package com.digital.dti.tasks.app.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskResponseDTO {

    private String nome;
    private OffsetDateTime data;

}
