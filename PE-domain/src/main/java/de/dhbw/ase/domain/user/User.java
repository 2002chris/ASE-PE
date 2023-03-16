package de.dhbw.ase.domain.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Column(name="name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name= "todos")
    @OneToMany
    private List<Todo> todos;
    @Column(name = "calendars")
    @OneToMany
    private List<Calendar> calendars;

    @Id
    @Column(name = "id")
    private UUID id;

    public User(String name, String password, List<Todo> todos, List<Calendar> calendars) {
        this.name = name;
        this.password = password;
        this.todos = todos;
        this.calendars = calendars;

        this.id = UUID.randomUUID();
    }
}
