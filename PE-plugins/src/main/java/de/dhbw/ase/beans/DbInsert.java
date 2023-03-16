package de.dhbw.ase.beans;

import de.dhbw.ase.application.group.GroupApplication;
import de.dhbw.ase.application.todo.TodoApplication;
import de.dhbw.ase.domain.group.Group;
import de.dhbw.ase.domain.todo.Todo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;

@Component
public class DbInsert {

    private final TodoApplication todoApplication;
    private final GroupApplication groupApplication;
    public DbInsert(final TodoApplication todoApplication, final GroupApplication groupApplication) {
        this.todoApplication = todoApplication;
        this.groupApplication = groupApplication;
    }

    @PostConstruct
    public void init(){
        Todo todo = new Todo(LocalDate.now(), "test123");
        Group group = new Group();
        todoApplication.save(todo);


    }
}
