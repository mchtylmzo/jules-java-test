package com.example.todoapp.infrastructure;

import com.example.todoapp.infrastructure.persistence.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbTodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUserId(Long userId);
}
