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

    @PostConstruct
    public void init(){
        Todo todo1 = new Todo(LocalDate.now(), "test123", new ArrayList<Tag>());
        Group group1 = new Group(new ArrayList<User>(),new ArrayList<Todo>());
        User user1 = new User("user1","1234",
                new ArrayList<Todo>(), new ArrayList<Calendar>());
        Calendar calendar1 = new Calendar(new ArrayList<Todo>(), new ArrayList<Reminder>());
        Reminder reminder1 = new Reminder(LocalDate.now(), "test1", "test123");
        Tag tag1 = new Tag("test");

        todoApplication.addTagToTodo(tag1,todo1);
        groupApplication.addUserToGroup(user1, group1);
        groupApplication.addTodoToGroup(todo1, group1);
        userApplication.addTodoToUser(todo1,user1);
        userApplication.addCalendarToUser(calendar1, user1);
        calendarApplication.addTodoToCalendar(todo1, calendar1);
        calendarApplication.addReminderToCalendar(reminder1, calendar1);

        tagApplication.save(tag1);
        todoApplication.save(todo1);
        groupApplication.save(group1);
        reminderApplication.save(reminder1);
        calendarApplication.save(calendar1);
        userApplication.save(user1);





    }
}
