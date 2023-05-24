package com.digital.dti.tasks.app.api.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TaskResDTO {
    
    private Long idTask;
    private String nomeTask;
    private OffsetDateTime dataTask;

}
