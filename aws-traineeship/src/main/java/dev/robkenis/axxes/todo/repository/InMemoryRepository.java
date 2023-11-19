package dev.robkenis.axxes.todo.repository;

import dev.robkenis.axxes.todo.model.Todo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;

//@ApplicationScoped
public class InMemoryRepository implements TodoRepository {

    private final HashMap<String, Todo> todos = new HashMap<>();

    @Override
    public List<Todo> getAll() {
        return todos.values().stream().toList();
    }

    @Override
    public void create(Todo todo) {
        todos.put(todo.title(), todo);
    }
}
