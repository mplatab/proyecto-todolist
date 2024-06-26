package com.mplatab.proyecto_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mplatab.proyecto_todolist.entity.Todo;

/**
 * TodoRepository
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
  
  
}