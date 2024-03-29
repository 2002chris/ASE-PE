package de.dhbw.ase.application.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
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
    private final TodoRepository todoRepository;

    @Autowired
    public UserApplicationService(final UserRepository userRepository,
                                  final TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
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

    @Override
    public User create(UserAttributeData data) {
        User user = new User(data.getName(), data.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User update(UserAttributeData data, String name) {
        User updatedUser = findUserByName(name).get();
        if(data.getName() != null){
            updatedUser.setName(data.getName());
        }
        if (data.getPassword() != null){
            updatedUser.setPassword(data.getPassword());
        }
        return save(updatedUser);
    }

    @Override
    public boolean delete(UUID id) {
        User user = userRepository.findUserById(id).orElse(null);
        if (user != null){
            for (Todo todo :
                    todoRepository.findTodoByUser(user)) {
                todoRepository.delete(todo);
            }
            userRepository.delete(user);
            return true;
        }

        return false;
    }
}
