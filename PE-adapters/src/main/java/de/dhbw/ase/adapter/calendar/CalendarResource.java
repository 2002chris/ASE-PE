package de.dhbw.ase.adapter.calendar;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import lombok.Getter;

import java.util.List;

@Getter
public class CalendarResource {
    private List<Reminder> reminder;
    private List<Todo> todos;

    public CalendarResource(final List<Todo> todos, final List<Reminder> reminder) {
        this.todos = todos;
        this.reminder = reminder;
    }
}
