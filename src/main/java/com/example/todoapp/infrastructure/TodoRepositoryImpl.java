package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.domain.TodoRepository;
import com.example.todoapp.infrastructure.mapper.TodoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final DbTodoRepository dbTodoRepository;
    private final TodoMapper todoMapper;

    public TodoRepositoryImpl(DbTodoRepository dbTodoRepository, TodoMapper todoMapper) {
        this.dbTodoRepository = dbTodoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public Todo save(Todo todo) {
        return todoMapper.toDomain(dbTodoRepository.save(todoMapper.toEntity(todo)));
    }

    @Override
    public List<Todo> findByUserId(Long userId) {
        return dbTodoRepository.findByUserId(userId).stream()
                .map(todoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
