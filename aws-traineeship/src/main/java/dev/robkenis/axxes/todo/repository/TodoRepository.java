package dev.robkenis.axxes.todo.repository;

import dev.robkenis.axxes.todo.model.Todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> getAll();

    void create(Todo todo);

}
