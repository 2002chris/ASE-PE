package de.dhbw.ase.domain.todo;

import de.dhbw.ase.domain.Tag.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "id")
    private UUID id;
    @Column(name = "until_date")
    private LocalDate untilDate;
    @Column(name = "content")
    private String content;

    @Column(name = "tags")
    @OneToMany()
    private List<Tag> tags;

    public Todo(LocalDate until_date, String content, List<Tag> tags) {
        this.id = UUID.randomUUID();
        this.untilDate = until_date;
        this.content = content;
        this.tags = tags;
    }


}
