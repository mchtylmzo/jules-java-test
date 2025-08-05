package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.domain.TodoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbTodoRepository extends TodoRepository, JpaRepository<Todo, Long> {
}
