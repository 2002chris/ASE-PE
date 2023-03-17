package de.dhbw.ase.adapter.reminder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReminderResource {
    private LocalDate date;
    private String title;
    private String description;

}
