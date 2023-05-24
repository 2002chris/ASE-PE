package de.dhbw.ase.adapter.calendar;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import lombok.Getter;

import java.util.List;

@Getter
public class CalendarResource {
//    private List<Reminder> reminder;
//    private List<Todo> todos;
    private String name;

    public CalendarResource(String name) {
//        this.todos = todos;
//        this.reminder = reminder;
        this.name = name;
    }
}
