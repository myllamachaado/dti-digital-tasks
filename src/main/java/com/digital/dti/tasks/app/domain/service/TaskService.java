package com.digital.dti.tasks.app.domain.service;

import com.digital.dti.tasks.app.domain.exceptionHandler.exceptions.EntidadeNaoEncontrada;
import com.digital.dti.tasks.app.domain.model.Task;
import com.digital.dti.tasks.app.domain.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Transactional
    public Task criarTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> listaTasks(){
        return taskRepository.findAll();
    }

    public Task buscaTask(Long idTask){
        return taskRepository.findById(idTask)
                .orElseThrow(() -> new EntidadeNaoEncontrada("Task não encontrada."));
    }

    @Transactional
    public void deletarTask(Long idTask){
        taskRepository.deleteById(idTask);
    }

}
