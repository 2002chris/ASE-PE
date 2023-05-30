package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.calendar.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ReminderAttributeData {
    private LocalDate date;
    private String title;
    private String description;
    private UUID calendarId;
}
