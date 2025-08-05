package com.example.todoapp.application;

import com.example.todoapp.domain.Todo;

import java.util.List;

public interface TodoService {
    Todo createTodo(Long userId, Todo todo);
    List<Todo> getTodosByUserId(Long userId);
}
