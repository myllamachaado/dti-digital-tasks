package com.digital.dti.tasks.app.domain.repository;

import com.digital.dti.tasks.app.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderByDataAsc();
}
