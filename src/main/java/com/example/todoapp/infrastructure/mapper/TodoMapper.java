package com.example.todoapp.infrastructure.mapper;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.infrastructure.persistence.TodoEntity;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    private final UserMapper userMapper;

    public TodoMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Todo toDomain(TodoEntity entity) {
        if (entity == null) {
            return null;
        }
        Todo domain = new Todo();
        domain.setId(entity.getId());
        domain.setDescription(entity.getDescription());
        domain.setCompleted(entity.isCompleted());
        if (entity.getUser() != null) {
            domain.setUser(userMapper.toDomain(entity.getUser()));
        }
        return domain;
    }

    public TodoEntity toEntity(Todo domain) {
        if (domain == null) {
            return null;
        }
        TodoEntity entity = new TodoEntity();
        entity.setId(domain.getId());
        entity.setDescription(domain.getDescription());
        entity.setCompleted(domain.isCompleted());
        if (domain.getUser() != null) {
            entity.setUser(userMapper.toEntity(domain.getUser()));
        }
        return entity;
    }
}
