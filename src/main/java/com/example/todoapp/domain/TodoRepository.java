package com.example.todoapp.domain;

import java.util.List;

public interface TodoRepository {
    Todo save(Todo todo);
    List<Todo> findByUserId(Long userId);
}
