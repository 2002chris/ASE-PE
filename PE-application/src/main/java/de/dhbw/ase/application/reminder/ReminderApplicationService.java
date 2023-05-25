package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.reminder.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReminderApplicationService implements ReminderApplication {

    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderApplicationService(final ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }


    @Override
    public List<Reminder> findAllReminders() {
        return reminderRepository.findAllReminder();
    }

    @Override
    public Optional<Reminder> findReminderById(UUID uuid) {
        return reminderRepository.findReminderById(uuid);
    }

    @Override
    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }
}
