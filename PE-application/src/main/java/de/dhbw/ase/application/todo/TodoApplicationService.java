package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoApplicationService implements TodoApplication{
    private final TodoApplication todoApplication;

    @Autowired
    public TodoApplicationService(TodoApplication todoApplication) {
        this.todoApplication = todoApplication;
    }

    public List<Todo> findAllTodos() {
        return this.todoApplication.findAllTodos();
    }

    @Override
    public Todo save(Todo todo) {
        return this.todoApplication.save(todo);
    }
}
