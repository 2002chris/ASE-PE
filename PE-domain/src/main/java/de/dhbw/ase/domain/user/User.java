package de.dhbw.ase.domain.user;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "todos")
    @OneToMany(fetch = FetchType.LAZY, mappedBy="user", targetEntity = Todo.class, cascade = CascadeType.REMOVE)
    private List<Todo> todos;
    @Column(name = "calendars")
    @OneToMany(fetch = FetchType.LAZY, mappedBy="user", targetEntity = Calendar.class, cascade = CascadeType.REMOVE)
    private List<Calendar> calendars;


    //TODO ändere id zum username, weil username ist schon eindeutig
    @Id
    @Type(type = "uuid-char")
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
