package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.calendar.CalendarRepository;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoApplicationService implements TodoApplication {
    private final TodoRepository todoRepository;
    private final CalendarRepository calendarRepository;

    @Autowired
    public TodoApplicationService(TodoRepository todoRepository, CalendarRepository calendarRepository) {
        this.todoRepository = todoRepository;
        this.calendarRepository = calendarRepository;
    }

    public List<Todo> findAllTodos() {
        return this.todoRepository.findAllTodos();
    }

    @Override
    public Optional<Todo> findTodoById(UUID id) {
        return this.todoRepository.findTodoById(id);
    }

    @Override
    public List<Todo> findTodoByUser(User user) {
        return this.todoRepository.findTodoByUser(user);
    }

    @Override
    public List<Todo> findTodoByTags(List<Tag> tags) {
        return this.todoRepository.findTodoByTags(tags);
    }

    @Override
    public Todo create(TodoAttributeData data, User user) {
        Calendar calendar = data.getCalendarId() != null ?
                calendarRepository.getCalendarById(data.getCalendarId()).get() : null;
        Todo todo = new Todo(data.getUntilDate(), data.getContent(),
                data.getTags(), user, calendar);
        return todoRepository.save(todo);
    }

//    @Override
//    public void addTagToTodo(Tag tag, Todo todo) {
//        List<Tag> tags = todo.getTags();
//        tags.add(tag);
//        todo.setTags(tags);
//    }


    @Override
    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }
}
