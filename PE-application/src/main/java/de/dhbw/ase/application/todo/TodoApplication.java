package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoApplication {

    Todo save(Todo todo);

    List<Todo> findAllTodos();

    Optional<Todo> findTodoById(UUID id);

    List<Todo> findTodoByUser(User user);

    List<Todo> findTodoByTags(List<Tag> tags);

    //TODO change to update todo
//    void addTagToTodo(Tag tag, Todo todo);

    Todo create(TodoAttributeData data, User user);


}
