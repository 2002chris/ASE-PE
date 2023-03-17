package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.reminder.Reminder;

import java.util.List;
import java.util.Optional;

public interface ReminderApplication {
    List<Reminder> findAllReminders();
    Optional<Reminder> findReminderById();
    Reminder save(Reminder reminder);
}
