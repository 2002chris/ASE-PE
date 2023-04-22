package de.dhbw.ase.domain.todo;

import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
/*
* Das ist ein aggregat, weil auf andere Entitäten verwiesen wird. Die Richtung vom Verweis muss klar sein. einfacher ist es, wenn beispielsweise der
* User eine Entität bleibt und der Calendar zum Aggregat wird, weil der Calendar auf den User verweist. Dadurch kann man einfachere abfragen machen und
* die Richtung ist klar definiert.
* */
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

    @Column(name="user_id", nullable=false)
    @Type(type="uuid-char")
    private UUID userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    private User user;

    @Column(name = "tags")
    @OneToMany()
    private List<Tag> tags;

    public Todo(LocalDate until_date, String content, List<Tag> tags, User user, UUID userId) {
        this.id = UUID.randomUUID();
        this.untilDate = until_date;
        this.content = content;
        this.tags = tags;
        this.user = user;
        this.userId = userId;
    }


}
