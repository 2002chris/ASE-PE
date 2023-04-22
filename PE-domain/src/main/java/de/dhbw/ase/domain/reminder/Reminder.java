package de.dhbw.ase.domain.reminder;

import de.dhbw.ase.domain.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "reminder")
@Getter
@Setter
@NoArgsConstructor
public class Reminder {
    @Id
    @Type(type="uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String title;

    @Column(name= "description")
    private String description;

    @Column(name = "todo_id", nullable = false)
    @Type(type = "uuid-char")
    private UUID todoId;

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false, updatable = false, insertable = false)
    private Todo todo;

    public Reminder(LocalDate date, String title, String description, Todo todo, UUID todoId) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.todo = todo;
        this.todoId = todoId;

        this.id = UUID.randomUUID();
    }
}
