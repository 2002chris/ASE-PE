package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.reminder.ReminderResource;
import de.dhbw.ase.adapter.reminder.ReminderToReminderResourceMapper;
import de.dhbw.ase.application.reminder.ReminderApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/reminder")
public class ReminderController {

    private final ReminderApplication reminderApplication;
    private final ReminderToReminderResourceMapper reminderToReminderResourceMapper;

    public ReminderController(final ReminderApplication reminderApplication, final ReminderToReminderResourceMapper reminderToReminderResourceMapper) {
        this.reminderApplication = reminderApplication;
        this.reminderToReminderResourceMapper = reminderToReminderResourceMapper;
    }

    @GetMapping
    public List<ReminderResource> getReminders() {
        return reminderApplication.findAllReminders().stream().map(reminderToReminderResourceMapper).collect(Collectors.toList());
    }
}
