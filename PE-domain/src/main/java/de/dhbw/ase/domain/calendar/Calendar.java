package de.dhbw.ase.domain.calendar;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
//    @Column(name = "todos")
//    @OneToMany()
//    private List<Todo> todos;
//    @Column(name = "reminder")
//    @OneToMany()
//    private List<Reminder> reminder;
    @Id
    @Type(type = "uuid-char")
    @Column(name = "calendar_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name="name")
    private String name;

    public Calendar( String name, User user) {
        this.id = UUID.randomUUID();
        this.user = user;
//        this.todos = todos;
//        this.reminder = reminders;
        this.name = name;
    }
}
