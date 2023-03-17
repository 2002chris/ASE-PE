package de.dhbw.ase.domain.calendar;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "calendar")
public class Calendar {
    @Column(name = "todos")
    @OneToMany()
    private List<Todo> todos;
    @Column(name = "reminder")
    @OneToMany()
    private List<Reminder> reminder;
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    public Calendar(List<Todo> todos, List<Reminder> reminders) {
        this.id = UUID.randomUUID();
        this.todos = todos;
        this.reminder = reminders;
    }
}
