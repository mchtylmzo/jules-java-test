package com.example.todoapp.infrastructure.mapper;

import com.example.todoapp.domain.User;
import com.example.todoapp.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        User domain = new User();
        domain.setId(entity.getId());
        domain.setUsername(entity.getUsername());
        domain.setPassword(entity.getPassword());
        return domain;
    }

    public UserEntity toEntity(User domain) {
        if (domain == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());
        return entity;
    }
}
