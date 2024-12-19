package com.example.task_manager_practice.service.impl;

import com.example.task_manager_practice.dto.TaskDTO;
import com.example.task_manager_practice.entity.Task;
import com.example.task_manager_practice.repository.TaskRepository;
import com.example.task_manager_practice.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task newTask = taskRepository.save(mapper.map(taskDTO, Task.class));
        return mapper.map(newTask, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Long id) {
        Task updatedTask = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
        updatedTask.setTitle(taskDTO.getTitle());
        updatedTask.setDescription(taskDTO.getDescription());
        updatedTask.setIsCompleted(taskDTO.getIsCompleted());

        Task saveUpdatedTask = taskRepository.save(updatedTask);
        return mapper.map(saveUpdatedTask, TaskDTO.class);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
        return mapper.map(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(task -> mapper.map(task, TaskDTO.class)).toList();
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
