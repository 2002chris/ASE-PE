package de.dhbw.ase.application.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationService implements UserApplication {

    private final UserApplication userApplication;

    @Autowired
    public UserApplicationService(final UserApplication userApplication){
        this.userApplication = userApplication;
    }

    @Override
    public List<User> findAllUsers() {
        return userApplication.findAllUsers();
    }

    @Override
    public User save(User user) {
        return userApplication.save(user);
    }

    @Override
    public void addTodoToUser(Todo todo, User user){
        List<Todo> todos = user.getTodos();
        todos.add(todo);
        user.setTodos(todos);
    }

    @Override
    public void addCalendarToUser(Calendar calendar, User user) {
        List<Calendar> calendars = user.getCalendars();
        calendars.add(calendar);
        user.setCalendars(calendars);
    }
}
