package de.dhbw.ase.adapter.reminder;

import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.reminder.ReminderRepository;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReminderToReminderResourceMapper implements Function<Reminder, ReminderResource> {
    @Override
    public ReminderResource apply(Reminder reminder) {
        return map(reminder);
    }

    ReminderResource map(Reminder reminder) {
        return new ReminderResource(reminder.getDate(), reminder.getTitle(),
                reminder.getDescription());
    }
}
