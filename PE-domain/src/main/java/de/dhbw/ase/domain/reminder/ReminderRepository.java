package de.dhbw.ase.domain.reminder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReminderRepository {

    List<Reminder> findAllReminder();

    Optional<Reminder> findReminderById(UUID uuid);

    Reminder save(Reminder reminder);

    void delete(Reminder reminder);
}
