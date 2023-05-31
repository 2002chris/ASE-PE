package de.dhbw.ase.application.reminder;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.calendar.CalendarRepository;
import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.reminder.ReminderRepository;
import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReminderApplicationService implements ReminderApplication {

    private final ReminderRepository reminderRepository;
    private final CalendarRepository calendarRepository;

    @Autowired
    public ReminderApplicationService(final ReminderRepository reminderRepository, CalendarRepository calendarRepository) {
        this.reminderRepository = reminderRepository;
        this.calendarRepository = calendarRepository;
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

    public Reminder create(ReminderAttributeData data, User user){
        Optional<Calendar> temp = calendarRepository.getCalendarById(data.getCalendarId());
        Calendar calendar = temp.orElse(null);
        if(calendarRepository.findCalendarsByUser(user).contains(calendar)){
            return save(new Reminder(
                    data.getDate(),
                    data.getTitle(),
                    data.getDescription(),
                    calendar
            ));
        }
        return null;
    }

    @Override
    public Reminder update(ReminderAttributeData data, UUID id) {
        Reminder reminder = reminderRepository.findReminderById(id).orElse(null);
        if (reminder != null) {
            if (data.getDate() != null)
                reminder.setDate(data.getDate());
            if (data.getCalendarId() != null)
                reminder.setCalendar(calendarRepository.findCalendarById(id).
                        orElse(reminder.getCalendar()));
            if (data.getDescription() != null)
                reminder.setDescription(data.getDescription());
            if (data.getTitle() != null)
                reminder.setTitle(data.getTitle());
            reminderRepository.save(reminder);
        }

        return reminder;
    }

    @Override
    public boolean delete(UUID id) {
        Reminder reminder = reminderRepository.findReminderById(id).orElse(null);
        if(reminder != null){
            reminderRepository.delete(reminder);
            return true;
        }
        return false;
    }
}
