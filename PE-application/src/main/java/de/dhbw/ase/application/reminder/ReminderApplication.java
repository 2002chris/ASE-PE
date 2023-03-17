package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.reminder.Reminder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReminderApplication {
    List<Reminder> findAllReminders();
    Optional<Reminder> findReminderById(UUID uuid);
    Reminder save(Reminder reminder);
}
