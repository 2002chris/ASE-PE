package de.dhbw.ase.application.calendar;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.calendar.CalendarRepository;
import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CalendarApplicationService implements CalendarApplication {

    private final CalendarRepository calendarRepository;

    @Autowired
    public CalendarApplicationService(final CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public List<Calendar> findAllCalendars() {
        return calendarRepository.findAllCalendars();
    }

    @Override
    public Optional<Calendar> findCalendarById(UUID id) {
        return calendarRepository.findCalendarById(id);
    }

    @Override
    public Calendar save(Calendar calendar) {
        return this.calendarRepository.save(calendar);
    }

    @Override
    public void addTodoToCalendar(Todo todo, Calendar calendar) {
//       List<Todo> todos = calendar.getTodos();
//       todos.add(todo);
//       calendar.setTodos(todos);
    }

    @Override
    public void addReminderToCalendar(Reminder reminder, Calendar calendar) {
//        List<Reminder> reminders = calendar.getReminder();
//        reminders.add(reminder);
//        calendar.setReminder(reminders);
    }

    @Override
    public Calendar create(CalendarAttributeData data, User user) {
        List<Calendar> userCalendars = this.calendarRepository.findCalendarsByUser(user);
        for (Calendar calendar :
                userCalendars) {
            if (calendar.getName().equals(data.getName())){
                return null;
            }
        }
        return save(new Calendar(data.getName(), user));
    }
}
