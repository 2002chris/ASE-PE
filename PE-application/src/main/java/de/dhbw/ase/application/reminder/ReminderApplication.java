package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReminderApplication {
    List<Reminder> findAllReminders();

    Optional<Reminder> findReminderById(UUID uuid);

    Reminder save(Reminder reminder);

    Reminder create(ReminderAttributeData data, User user);

    Reminder update(ReminderAttributeData data, UUID id);
}
