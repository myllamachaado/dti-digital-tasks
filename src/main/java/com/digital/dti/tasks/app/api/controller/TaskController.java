package com.digital.dti.tasks.app.api.controller;

import com.digital.dti.tasks.app.api.assembler.TaskAssembler;
import com.digital.dti.tasks.app.api.dto.request.TaskRequestDTO;
import com.digital.dti.tasks.app.api.dto.response.TaskResponseDTO;
import com.digital.dti.tasks.app.domain.model.Task;
import com.digital.dti.tasks.app.domain.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private TaskService taskService;
    private TaskAssembler taskAssembler;

    @GetMapping
    public List<TaskResponseDTO> listar(){
        return taskAssembler.toCollection(taskService.listaTasks());
    }

    @GetMapping("/{idTask}")
    public ResponseEntity<TaskResponseDTO> buscar(@PathVariable Long idTask){
        return taskService.buscaTask(idTask)
                .map(task -> ResponseEntity.ok(taskAssembler.toModel(task)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskResponseDTO> criar(@Valid @RequestBody TaskRequestDTO taskRequest){
        Task task = taskAssembler.toEntity(taskRequest);
        return ResponseEntity.ok(taskAssembler.toModel(taskService.criarTask(task)));
    }

    @DeleteMapping("/{idTask}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@Valid @PathVariable Long idTask){
        taskService.deletarTask(idTask);
    }

}
