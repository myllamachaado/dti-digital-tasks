package com.digital.dti.tasks.app.domain.service;

import com.digital.dti.tasks.app.domain.exceptionHandler.exceptions.EntidadeNaoEncontradaException;
import com.digital.dti.tasks.app.domain.model.Task;
import com.digital.dti.tasks.app.domain.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void criarTaskComSucesso() {
        Task taskEsperada = taskBuilder();  // Given
        when(taskRepository.save(taskEsperada)).thenReturn(taskEsperada);   //When
        assertEquals(taskEsperada, taskService.criarTask(taskEsperada));  //Then
    }

    @Test
    public void tentaInserirNomeComMaisDe255CaracteresSemSucesso(){
        Task task = new Task();
        task.setNome("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam augue lorem, " +
                "cursus et viverra in, aliquet a libero. Vivamus vel ipsum sit amet ipsum consequat " +
                "dignissim vitae vitae mi. Proin sed nibh erat. Etiam vel dui eget urna rutrum faucibus " +
                "eget nec mi. ");
        assertNull(taskService.criarTask(task));
    }

    @Test
    public void tentaInserirDataNulaSemSucesso(){
        Task task = new Task();
        task.setData(null);
        assertNull(taskService.criarTask(task));
    }

    @Test
    public void tentaInserirTaskSemDadosSemSucesso(){
        Task task = new Task();
        assertNull(taskService.criarTask(task));
    }

    @Test
    void listaTasksComSucesso() {
        Task taskEsperada = taskBuilder();
        List<Task> listaDeTasks = new ArrayList<>();
        listaDeTasks.add(taskEsperada);
        when(taskRepository.findAllByOrderByDataAsc()).thenReturn(listaDeTasks);
        assertEquals(listaDeTasks, taskService.listaTasks());
    }

    @Test
    void buscaTaskComSucesso() {
        Optional<Task> taskEsperada = Optional.of(taskBuilder());
        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskBuilder()));
        assertEquals(taskEsperada, taskService.buscaTask(1L));
    }

    @Test
    void buscaTaskQueNaoExisteERetornaUmOptionalVazio() {
        Optional<Task> taskEsperada = Optional.empty();
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());
        assertEquals(taskEsperada, taskService.buscaTask(1L));
    }

    @Test
    void deletarTaskComSucesso() {
        Optional<Task> taskEsperada = Optional.of(taskBuilder());
        doNothing().when(taskRepository).deleteById(1L);
        when(taskRepository.findById(1L)).thenReturn(taskEsperada);
        taskService.deletarTask(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void tentaDeletarTasQueNaoExiste() {
        Optional<Task> task = Optional.empty();
        when(taskRepository.findById(1L)).thenReturn(task);
        assertThrows(EntidadeNaoEncontradaException.class,
                () -> {taskService.deletarTask(1L);
                }, "Lembrete não existe."); //Then
    }

    private Task taskBuilder(){
        Task task = new Task();
        task.setData(LocalDate.now());
        task.setNome("Task Teste");
        return task;
    }

}