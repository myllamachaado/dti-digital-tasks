package com.digital.dti.tasks.app.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class TaskRequestDTO {

    @Valid
    @NotBlank
    @Size(max=255)
    private String nome;

    @Valid
    @NotNull
    private LocalDate data;


}
