package de.dhbw.ase.domain.reminder;

import de.dhbw.ase.domain.calendar.Calendar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reminder")
@Getter
@Setter
@NoArgsConstructor
public class Reminder {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "reminder_id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public Reminder(LocalDate date, String title, String description, Calendar calendar) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.calendar = calendar;

        this.id = UUID.randomUUID();
    }
}
