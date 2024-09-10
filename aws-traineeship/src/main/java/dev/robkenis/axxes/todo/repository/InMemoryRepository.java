package dev.robkenis.axxes.todo.repository;

import dev.robkenis.axxes.todo.model.Todo;
import dev.robkenis.axxes.todo.service.QueueConsumer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class InMemoryRepository implements TodoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryRepository.class);

    private final Map<String, Todo> todos = new HashMap<String, Todo>();

    @Override
    public List<Todo> getAll() {
        LOGGER.info("Getting all todos");
        return todos.values().stream().toList();
    }

    @Override
    public void create(Todo todo) {
        LOGGER.info("Creating todo: {}", todo.title());
        todos.put(todo.title(), todo);
    }
}
