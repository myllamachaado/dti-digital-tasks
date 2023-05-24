package com.digital.dti.tasks.app.api.assembler;

import com.digital.dti.tasks.app.api.dto.request.TaskRequestDTO;
import com.digital.dti.tasks.app.api.dto.response.TaskResponseDTO;
import com.digital.dti.tasks.app.domain.model.Task;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class TaskAssembler {

    private ModelMapper mapper;

    public TaskResponseDTO toModel(Task task){
        return mapper.map(task, TaskResponseDTO.class);
    }

    public List<TaskResponseDTO> toCollection(List<Task> tasks){
        return tasks.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Task toEntity(TaskRequestDTO task){
        return mapper.map(task, Task.class);
    }

}
