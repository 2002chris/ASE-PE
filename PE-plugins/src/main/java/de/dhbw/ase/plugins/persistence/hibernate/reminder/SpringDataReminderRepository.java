package de.dhbw.ase.plugins.persistence.hibernate.reminder;

import de.dhbw.ase.domain.reminder.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataReminderRepository extends JpaRepository<Reminder, UUID> {
    Optional<Reminder> findReminderById(UUID id);
}
