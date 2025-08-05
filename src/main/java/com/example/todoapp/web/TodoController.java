package com.example.todoapp.web;

import com.example.todoapp.application.TodoService;
import com.example.todoapp.domain.Todo;
import com.example.todoapp.web.dto.CreateTodoRequest;
import com.example.todoapp.web.dto.TodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/{userId}/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoDto createTodo(@PathVariable Long userId, @RequestBody CreateTodoRequest request) {
        Todo todo = new Todo();
        todo.setDescription(request.getDescription());
        Todo createdTodo = todoService.createTodo(userId, todo);
        return toTodoDto(createdTodo);
    }

    @GetMapping
    public List<TodoDto> getTodosForUser(@PathVariable Long userId) {
        return todoService.getTodosByUserId(userId).stream()
                .map(this::toTodoDto)
                .collect(Collectors.toList());
    }

    private TodoDto toTodoDto(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setDescription(todo.getDescription());
        dto.setCompleted(todo.isCompleted());
        return dto;
    }
}
