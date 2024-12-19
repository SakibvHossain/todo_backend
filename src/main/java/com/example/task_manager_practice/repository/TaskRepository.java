package com.example.task_manager_practice.repository;

import com.example.task_manager_practice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
