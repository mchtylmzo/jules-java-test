package com.example.todoapp.infrastructure;

import com.example.todoapp.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserRepository extends JpaRepository<UserEntity, Long> {
}
