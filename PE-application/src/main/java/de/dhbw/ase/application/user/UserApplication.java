package de.dhbw.ase.application.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserApplication {

    List<User> findAllUsers();

    User save(User user);

    //TODO evaluiere umsetzung von diesem use case
    void addTodoToUser(Todo todo, User user);

    void addCalendarToUser(Calendar calendar, User user);

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByName(String name);

    User create(UserAttributeData data);

    User update(UserAttributeData data, String name);
}
