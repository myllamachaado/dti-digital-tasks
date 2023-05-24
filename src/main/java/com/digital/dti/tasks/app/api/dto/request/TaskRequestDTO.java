package com.digital.dti.tasks.app.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskRequestDTO {

    @Valid
    @NotBlank
    private String nome;

    @Valid
    @NotNull
    private OffsetDateTime data;
}
