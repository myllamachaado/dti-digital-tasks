package com.digital.dti.tasks.app.api.controller;

import com.digital.dti.tasks.app.domain.model.Task;
import com.digital.dti.tasks.app.domain.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private TaskService taskService;

    @GetMapping
    public List<Task> listar(){
        return taskService.listaTasks();
    }

    @GetMapping("/{idTask}")
    public Task buscar(@Valid @PathVariable Long idTask){
        return taskService.buscaTask(idTask);
    }

    @PostMapping
    public Task criar(@Valid @RequestBody Task task){
        return taskService.criarTask(task);
    }

    @DeleteMapping("/{idTask}")
    public void deletar(@Valid @PathVariable Long idTask){
        taskService.deletarTask(idTask);
    }

}
