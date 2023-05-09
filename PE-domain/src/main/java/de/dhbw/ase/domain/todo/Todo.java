package de.dhbw.ase.domain.todo;

import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "todo")
public class Todo {
    @Id
    @Type(type="uuid-char") //Viktor hat geholfen und will die Credits haben <- jetzt kann er sich einmal geil fühlen
    @Column(name = "id")
    private UUID id;
    @Column(name = "until_date")
    private LocalDate untilDate;
    @Column(name = "content")
    private String content;

    //todo unidirektionale verbindung zum User
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "tags")
    @OneToMany()
    private List<Tag> tags;

    public Todo(LocalDate until_date, String content, List<Tag> tags, User user) {
        this.id = UUID.randomUUID();
        this.untilDate = until_date;
        this.content = content;
        this.tags = tags;
        this.user = user;
    }


}
