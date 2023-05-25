package com.digital.dti.tasks.app.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@ToString
@Getter
@Setter
public class TaskResponseDTO {

    private Long id;
    private String nome;
    private LocalDate data;

}
