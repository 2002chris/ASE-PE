package de.dhbw.ase.rest.reminder;

import de.dhbw.ase.adapter.reminder.ReminderResource;
import de.dhbw.ase.adapter.reminder.ReminderToReminderResourceMapper;
import de.dhbw.ase.application.reminder.ReminderApplication;
import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.reminder.Reminder;
import de.dhbw.ase.domain.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/reminder")
public class ReminderController {

    private final ReminderApplication reminderApplication;
    private final ReminderToReminderResourceMapper reminderToReminderResourceMapper;
    private final UserApplication userApplication;

    public ReminderController(final ReminderApplication reminderApplication,
                              final ReminderToReminderResourceMapper reminderToReminderResourceMapper,
                              final UserApplication userApplication) {
        this.reminderApplication = reminderApplication;
        this.reminderToReminderResourceMapper = reminderToReminderResourceMapper;
        this.userApplication = userApplication;
    }

    @GetMapping
    public List<ReminderResource> getReminders() {
        return reminderApplication.findAllReminders().stream().map(reminderToReminderResourceMapper).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ReminderResource> create(@RequestBody ReminderData data, Principal user){
        Reminder reminder = reminderApplication.create(data, userApplication.findUserByName(user.getName()).get());
        return reminder != null ?
                ResponseEntity.ok(reminderToReminderResourceMapper.apply(reminder)) :
                ResponseEntity.badRequest().build();
    }

    @PutMapping(params = {"id"})
    public ResponseEntity<ReminderResource> update(@RequestBody ReminderData data,
                                                   @RequestParam String id){
        Reminder reminder = reminderApplication.update(data, UUID.fromString(id));
        return reminder != null ?
                ResponseEntity.ok(reminderToReminderResourceMapper.apply(reminder)) :
                ResponseEntity.badRequest().build();
    }
}
