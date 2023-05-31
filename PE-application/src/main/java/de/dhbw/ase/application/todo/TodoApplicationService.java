package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.calendar.CalendarRepository;
import de.dhbw.ase.domain.tag.TagRepository;
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
    private final TagRepository tagRepository;

    @Autowired
    public TodoApplicationService(TodoRepository todoRepository,
                                  CalendarRepository calendarRepository,
                                  TagRepository tagRepository) {
        this.todoRepository = todoRepository;
        this.calendarRepository = calendarRepository;
        this.tagRepository = tagRepository;
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
                calendarRepository.getCalendarById(data.getCalendarId()).orElse(null) : null;
        Todo todo = calendar != null ?
                new Todo(data.getUntilDate(), data.getContent(),
                data.getTags(), null, calendar) :
                 new Todo(data.getUntilDate(), data.getContent(),
                         data.getTags(), user, null);
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> findTodosByCalendar(Calendar calendar) {
        return todoRepository.findTodosByCalendar(calendar);
    }

    @Override
    public Todo update(TodoAttributeData data, UUID id) {
        Todo todo = todoRepository.findTodoById(id).orElse(null);
        List<Tag> allTags = tagRepository.findAllTags();
        for (Tag tag:
                data.getTags()) {
            if(!allTags.contains(tag)){
                tagRepository.save(tag);
            }
        }
        if(todo != null){
             if(data.getUntilDate() != null){
                todo.setUntilDate(data.getUntilDate());
            }
             if(data.getContent() != null){
                 todo.setContent(data.getContent());
             }

            if(data.getTags() != null){
                todo.setTags(data.getTags());
            }
            todoRepository.save(todo);
        }
        return todo;
    }

    @Override
    public boolean delete(UUID id) {
        Todo todo = todoRepository.findTodoById(id).orElse(null);
        if (todo != null){
            todoRepository.delete(todo);
            return true;
        }

        return false;
    }


    @Override
    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }
}
