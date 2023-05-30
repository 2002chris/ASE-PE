package de.dhbw.ase.plugins.persistence.hibernate.todo;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
import de.dhbw.ase.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoRepositoryBridge implements TodoRepository {
    private final SpringDataTodoRepository springDataTodoRepository;

    public TodoRepositoryBridge(final SpringDataTodoRepository springDataTodoRepository) {
        this.springDataTodoRepository = springDataTodoRepository;
    }

    @Override
    public List<Todo> findAllTodos() {
        return springDataTodoRepository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(UUID id) {
        return springDataTodoRepository.findTodoById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return springDataTodoRepository.save(todo);
    }

    @Override
    public List<Todo> findTodoByUser(User user) {
        return springDataTodoRepository.findByUser(user);
    }

    @Override
    public List<Todo> findTodosByCalendar(Calendar calendar) {
        return springDataTodoRepository.findTodosByCalendar(calendar);
    }

    public List<Todo> findTodoByTags(List<Tag> tags) {
        return springDataTodoRepository.findByTagsIn(tags);
    }

//    @Override
//    public List<Todo> findUserTodos(String username) {
//        return springDataTodoRepository.findUserTodos(username);
//    }
}
