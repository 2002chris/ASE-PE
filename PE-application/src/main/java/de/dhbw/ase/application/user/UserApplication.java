package de.dhbw.ase.application.user;

import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;

import java.util.List;

public interface UserApplication {

    List<User> findAllUsers();

    User save(User user);

    void addTodoToUser(Todo todo, User user);
}
