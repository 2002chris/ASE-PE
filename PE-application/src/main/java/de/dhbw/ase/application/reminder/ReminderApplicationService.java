package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.reminder.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderApplicationService implements ReminderApplication{

    private final ReminderApplication reminderApplication;

    @Autowired
    public ReminderApplicationService(final ReminderApplication reminderApplication) {
        this.reminderApplication = reminderApplication;
    }


    @Override
    public List<Reminder> findAllReminders() {
        return reminderApplication.findAllReminders();
    }

    @Override
    public Optional<Reminder> findReminderById() {
        return reminderApplication.findReminderById();
    }

    @Override
    public Reminder save(Reminder reminder) {
        return reminderApplication.save(reminder);
    }
}
