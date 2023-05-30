package de.dhbw.ase.application.calendar;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CalendarApplication {
    List<Calendar> findAllCalendars();

    Optional<Calendar> findCalendarById(UUID id);

    Calendar save(Calendar calendar);

    //TODO evaluiere umsetzung von diesen use cases
    void addTodoToCalendar(Todo todo, Calendar calendar);

    void addReminderToCalendar(Reminder reminder, Calendar calendar);

    Calendar create(CalendarAttributeData data, User user);
}
