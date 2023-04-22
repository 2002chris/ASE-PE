package de.dhbw.ase.domain.calendar;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
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
@Table(name = "calendar")
public class Calendar {
    @Column(name = "todos")
    @OneToMany()
    private List<Todo> todos;
    @Column(name = "reminder")
    @OneToMany(fetch = FetchType.LAZY, mappedBy="todo", targetEntity = Reminder.class, cascade = CascadeType.REMOVE)
    private List<Reminder> reminder;
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    private User user;
    @Column(name="user_id", nullable=false)
    @Type(type="uuid-char")
    private UUID userId;

    public Calendar(List<Todo> todos, List<Reminder> reminders, String name, User user, UUID userId) {
        this.id = UUID.randomUUID();
        this.todos = todos;
        this.reminder = reminders;
        this.name = name;
        this.user = user;
        this.userId = userId;
    }
}
