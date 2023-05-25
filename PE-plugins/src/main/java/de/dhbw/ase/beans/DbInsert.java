package de.dhbw.ase.beans;

import de.dhbw.ase.application.calendar.CalendarApplication;
import de.dhbw.ase.application.reminder.ReminderApplication;
import de.dhbw.ase.application.tag.TagApplication;
import de.dhbw.ase.application.todo.TodoApplication;
import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class DbInsert {

    private final TodoApplication todoApplication;
    private final UserApplication userApplication;
    private final CalendarApplication calendarApplication;
    private final ReminderApplication reminderApplication;
    private final TagApplication tagApplication;
    public DbInsert(final TodoApplication todoApplication,
                    final UserApplication userApplication, final CalendarApplication calendarApplication,
                    final ReminderApplication reminderApplication,final TagApplication tagApplication) {
        this.todoApplication = todoApplication;
        this.userApplication = userApplication;
        this.calendarApplication = calendarApplication;
        this.reminderApplication = reminderApplication;
        this.tagApplication = tagApplication;
    }

    @PostConstruct
    public void init(){
        Tag tag = new Tag("arbeit");
        Tag tag2 = new Tag("privat");
        for (int i = 0; i < 10; i++) {
            User user = new User("user"+i, "test");
            Calendar calendar = new Calendar("calendar"+i, user);

            Todo calendarTodo = new Todo(LocalDate.now(), "calendarTodo" + i,
                    new ArrayList<>(){{
                        this.add(tag);}
                    },
                    null, calendar);
            Todo userTodo = new Todo(LocalDate.now(), "userTodo"+i,
                    new ArrayList<>(){{
                        this.add(tag2);
                        this.add(tag);
                    }},
                    user, null);
            Reminder reminder = new Reminder(LocalDate.now(), "reminder"+i, "test"+i, calendar);
            this.userApplication.save(user);
            this.calendarApplication.save(calendar);
            this.tagApplication.save(tag);
            this.tagApplication.save(tag2);
            this.todoApplication.save(calendarTodo);
            this.todoApplication.save(userTodo);
            this.reminderApplication.save(reminder);
        }





    }
}
