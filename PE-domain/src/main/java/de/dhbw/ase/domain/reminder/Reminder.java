package de.dhbw.ase.domain.reminder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String title;

    @Column(name= "description")
    private String description;

    public Reminder(LocalDate date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;

        this.id = UUID.randomUUID();
    }
}
