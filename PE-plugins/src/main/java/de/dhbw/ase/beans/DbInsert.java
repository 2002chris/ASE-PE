package de.dhbw.ase.beans;

import de.dhbw.ase.application.calendar.CalendarApplication;
import de.dhbw.ase.application.group.GroupApplication;
import de.dhbw.ase.application.reminder.ReminderApplication;
import de.dhbw.ase.application.tag.TagApplication;
import de.dhbw.ase.application.todo.TodoApplication;
import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.group.Group;
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
    private final GroupApplication groupApplication;
    private final UserApplication userApplication;
    private final CalendarApplication calendarApplication;
    private final ReminderApplication reminderApplication;
    private final TagApplication tagApplication;
    public DbInsert(final TodoApplication todoApplication, final GroupApplication groupApplication,
                    final UserApplication userApplication, final CalendarApplication calendarApplication,
                    final ReminderApplication reminderApplication,final TagApplication tagApplication) {
        this.todoApplication = todoApplication;
        this.groupApplication = groupApplication;
        this.userApplication = userApplication;
        this.calendarApplication = calendarApplication;
        this.reminderApplication = reminderApplication;
        this.tagApplication = tagApplication;
    }

//    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            Todo todo = new Todo(LocalDate.now(), "test"+i, new ArrayList<Tag>());
            Group group = new Group(new ArrayList<User>(),new ArrayList<Todo>());
            User user = new User("user"+i,"1234"+i,
                    new ArrayList<Todo>(), new ArrayList<Calendar>());
            Calendar calendar = new Calendar(new ArrayList<Todo>(), new ArrayList<Reminder>(), "test"+i);
            Reminder reminder = new Reminder(LocalDate.now(), "test1", "test123");
            Tag tag = new Tag("test"+i);

            todoApplication.addTagToTodo(tag,todo);
            groupApplication.addUserToGroup(user, group);
            groupApplication.addTodoToGroup(todo, group);
            userApplication.addTodoToUser(todo,user);
            userApplication.addCalendarToUser(calendar, user);
            calendarApplication.addTodoToCalendar(todo, calendar);
            calendarApplication.addReminderToCalendar(reminder, calendar);

            tagApplication.save(tag);
            todoApplication.save(todo);
            reminderApplication.save(reminder);
            calendarApplication.save(calendar);
            userApplication.save(user);
            groupApplication.save(group);
        }





    }
}
