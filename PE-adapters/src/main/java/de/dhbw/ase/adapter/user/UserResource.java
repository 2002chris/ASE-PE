package de.dhbw.ase.adapter.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;

import java.util.List;

public class UserResource {

    private String name;
    private String password;
    private List<Todo> todos;
    private List<Calendar> calendars;

    public UserResource(String name, String password, List<Todo> todos, List<Calendar> calendars) {
        this.name = name;
        this.password = password;
        this.todos = todos;
        this.calendars = calendars;
    }
}
