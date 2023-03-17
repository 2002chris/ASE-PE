package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.calendar.CalendarRepository;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoApplicationService implements TodoApplication{
    private final TodoRepository todoRepository;

    @Autowired
    public TodoApplicationService(TodoRepository calendarRepository) {
        this.todoRepository = calendarRepository;
    }

    public List<Todo> findAllTodos() {
        return this.todoRepository.findAllTodos();
    }

    @Override
    public void addTagToTodo(Tag tag, Todo todo) {
        List<Tag> tags = todo.getTags();
        tags.add(tag);
        todo.setTags(tags);
    }

    @Override
    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }
}
