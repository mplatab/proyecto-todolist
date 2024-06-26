package com.mplatab.proyecto_todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mplatab.proyecto_todolist.entity.Todo;
import com.mplatab.proyecto_todolist.repository.TodoRepository;

@Service
public class TodoServiceImpl implements ITodoService{

  private final TodoRepository todoRepository;

  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public List<Todo> create(Todo todo) {
    todoRepository.save(todo);
    return list();
  }

  @Override
  public List<Todo> list() {
    Sort sort = Sort.by("priority").descending().and(
      Sort.by("title").ascending()
    );
    return todoRepository.findAll(sort);
  }

  @Override
  public List<Todo> update(Todo todo) {
    todoRepository.save(todo);
    return list();
  }

  @Override
  public List<Todo> delete(Long id) {
    todoRepository.deleteById(id);
    return list();
  }
  
}
