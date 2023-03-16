package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.todo.Todo;

import java.util.List;

public interface TodoApplication {

    Todo save(Todo todo);

    List<Todo> findAllTodos();

}
