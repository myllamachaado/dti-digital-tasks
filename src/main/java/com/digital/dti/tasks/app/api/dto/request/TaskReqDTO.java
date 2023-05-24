package com.digital.dti.tasks.app.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskReqDTO {

    @Valid
    @NotBlank
    private Long idTask;

    @Valid
    @NotBlank
    private String nomeTask;

    @NotBlank
    private OffsetDateTime dataTask;
}
