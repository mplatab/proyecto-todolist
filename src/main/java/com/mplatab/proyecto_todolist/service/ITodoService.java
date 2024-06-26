package com.mplatab.proyecto_todolist.service;

import java.util.List;

import com.mplatab.proyecto_todolist.entity.Todo;

public interface ITodoService {

  List<Todo> create(Todo todo);

  List<Todo> list();

  List<Todo> update(Todo todo);

  List<Todo> delete(Long id);



}
