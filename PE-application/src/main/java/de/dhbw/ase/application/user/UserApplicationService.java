package de.dhbw.ase.application.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import de.dhbw.ase.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserApplicationService implements UserApplication {

    private final UserRepository userRepository;

    @Autowired
    public UserApplicationService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addTodoToUser(Todo todo, User user) {
//        user.getTodos().add(todo);
    }

    @Override
    public void addCalendarToUser(Calendar calendar, User user) {
//        user.getCalendars().add(calendar);
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
