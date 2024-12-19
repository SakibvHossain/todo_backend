package com.example.task_manager_practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean isCompleted;
}
