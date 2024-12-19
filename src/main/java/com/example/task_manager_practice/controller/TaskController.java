package com.example.task_manager_practice.controller;


import com.example.task_manager_practice.dto.TaskDTO;
import com.example.task_manager_practice.payloads.ApiResponse;
import com.example.task_manager_practice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping("all_task")
    public ApiResponse<List<TaskDTO>> getAllTasks() {
        return new ApiResponse<>(HttpStatus.OK,taskService.getAllTasks());
    }

    @GetMapping("taskById/{id}")
    public ApiResponse<TaskDTO> getTaskById(@PathVariable Long id) {
        return new ApiResponse<>(HttpStatus.OK,taskService.getTaskById(id));
    }

    @PostMapping("create")
    public ApiResponse<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ApiResponse<>(HttpStatus.OK,taskService.createTask(taskDTO));
    }

    @PutMapping("update/{id}")
    public ApiResponse<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return new ApiResponse<>(HttpStatus.OK, taskService.updateTask(taskDTO, id));
    }

    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}
