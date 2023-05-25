package de.dhbw.ase.adapter.todo;

import de.dhbw.ase.domain.todo.Todo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoToTodoResourceMapper implements Function<Todo, TodoResource> {
    @Override
    public TodoResource apply(Todo todo) {
        return map(todo);
    }

    private TodoResource map(final Todo todo){
        return new TodoResource(todo.getUntilDate(), todo.getContent()
                , todo.getTags()
        );
    }
}
