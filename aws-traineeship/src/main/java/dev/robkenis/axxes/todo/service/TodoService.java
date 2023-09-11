package dev.robkenis.axxes.todo.service;

import dev.robkenis.axxes.todo.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAll();

    void create(Todo todo);

}
