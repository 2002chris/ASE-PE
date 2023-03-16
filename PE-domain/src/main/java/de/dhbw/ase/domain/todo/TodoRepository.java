package de.dhbw.ase.domain.todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {

    List<Todo> findAllTodos();

    Optional<Todo> findTodoById(UUID uuid);

    Todo save(Todo todo);
}
