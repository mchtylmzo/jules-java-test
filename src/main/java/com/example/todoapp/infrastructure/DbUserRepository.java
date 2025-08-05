package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.User;
import com.example.todoapp.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserRepository extends UserRepository, JpaRepository<User, Long> {
}
