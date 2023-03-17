package de.dhbw.ase.plugins.persistence.hibernate.reminder;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.reminder.ReminderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ReminderRepositoryBridge implements ReminderRepository {

    private final SpringDataReminderRepository springDataReminderRepository;

    public ReminderRepositoryBridge(final SpringDataReminderRepository springDataReminderRepository) {
        this.springDataReminderRepository = springDataReminderRepository;
    }

    @Override
    public List<Reminder> findAllReminder() {
        return springDataReminderRepository.findAll();
    }

    @Override
    public Optional<Reminder> findReminderById(UUID uuid) {
        return springDataReminderRepository.findReminderById(uuid);
    }

    @Override
    public Reminder save(Reminder reminder) {
        return springDataReminderRepository.save(reminder);
    }
}
