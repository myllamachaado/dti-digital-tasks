package com.digital.dti.tasks.app.domain.service;

import com.digital.dti.tasks.app.domain.exceptionHandler.exceptions.EntidadeNaoEncontradaException;
import com.digital.dti.tasks.app.domain.model.Task;
import com.digital.dti.tasks.app.domain.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Transactional
    public Task criarTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> listaTasks(){
        return taskRepository.findAllByOrderByDataAsc();
    }

    public Optional<Task> buscaTask(Long idTask){
        return taskRepository.findById(idTask);
    }

    @Transactional
    public void deletarTask(Long idTask){
        if(!this.buscaTask(idTask).isPresent()){
            throw new EntidadeNaoEncontradaException("Lembrete não existe.");
        }
        taskRepository.deleteById(idTask);
    }

}
