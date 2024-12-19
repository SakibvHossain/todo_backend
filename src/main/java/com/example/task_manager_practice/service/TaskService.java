package com.example.task_manager_practice.service;

import com.example.task_manager_practice.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(TaskDTO taskDTO, Long id);
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getAllTasks();
    void deleteTaskById(Long id);
}
