package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.User;
import com.example.todoapp.domain.UserRepository;
import com.example.todoapp.infrastructure.mapper.UserMapper;
import com.example.todoapp.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DbUserRepository dbUserRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(DbUserRepository dbUserRepository, UserMapper userMapper) {
        this.dbUserRepository = dbUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedEntity = dbUserRepository.save(userEntity);
        return userMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return dbUserRepository.findById(id).map(userMapper::toDomain);
    }
}
