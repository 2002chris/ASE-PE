package de.dhbw.ase.domain.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "todo")
public class Todo {
    @Id
    @Type(type = "uuid-char") //Viktor hat geholfen und will die Credits haben <- jetzt kann er sich einmal geil fühlen
    @Column(name = "todo_id")
    private UUID id;
    @Column(name = "until_date")
    private LocalDate untilDate;
    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "todo_tags", joinColumns = @JoinColumn(name = "todo_id"), inverseJoinColumns = @JoinColumn(name = "tag_name"))
    private Set<Tag> tags;

    public Todo(LocalDate until_date, String content, Set<Tag> tags, User user, Calendar calendar) {
        this.id = UUID.randomUUID();
        this.untilDate = until_date;
        this.content = content;
        this.tags = tags;
        this.user = user;
        this.calendar = calendar;
    }


}
