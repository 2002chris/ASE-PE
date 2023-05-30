package de.dhbw.ase.domain.todo;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {

    List<Todo> findAllTodos();

    Optional<Todo> findTodoById(UUID uuid);

    Todo save(Todo todo);

    List<Todo> findTodoByTags(List<Tag> tags);

    List<Todo> findTodoByUser(User user);

    List<Todo> findTodosByCalendar(Calendar calendar);
}
