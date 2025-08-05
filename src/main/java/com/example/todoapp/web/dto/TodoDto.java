package com.example.todoapp.web.dto;

import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private String description;
    private boolean completed;
}
