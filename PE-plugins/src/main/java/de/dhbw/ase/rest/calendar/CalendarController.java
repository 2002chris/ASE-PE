package de.dhbw.ase.rest.calendar;

import de.dhbw.ase.adapter.calendar.CalendarResource;
import de.dhbw.ase.adapter.calendar.CalendarToCalendarResourceMapper;
import de.dhbw.ase.adapter.todo.TodoResource;
import de.dhbw.ase.application.calendar.CalendarApplication;
import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.calendar.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/calendar")
public class CalendarController {
    private final CalendarApplication calendarApplication;
    private final CalendarToCalendarResourceMapper calendarToCalendarResourceMapper;
    private final UserApplication userApplication;

    @Autowired
    public CalendarController(final CalendarApplication calendarApplication,
                              final CalendarToCalendarResourceMapper calendarToCalendarResourceMapper,
                              final UserApplication userApplication) {
        this.calendarApplication = calendarApplication;
        this.calendarToCalendarResourceMapper = calendarToCalendarResourceMapper;
        this.userApplication = userApplication;
    }

    //TODO change to get only calendars belonging to user
    @RequestMapping(method = RequestMethod.GET)
    public List<CalendarResource> getCalendars() {
        return calendarApplication.findAllCalendars().stream().map(calendarToCalendarResourceMapper).collect(Collectors.toList());
    }

    @GetMapping(params = {"id"})
    public CalendarResource getCalendar(@RequestParam String id) {
        return calendarApplication.findCalendarById(UUID.fromString(id)).stream().map(calendarToCalendarResourceMapper).findFirst().get();
    }

    @PostMapping
    public ResponseEntity<CalendarResource> create(@RequestBody CalendarData data, Principal user) {
        Calendar calendar = calendarApplication.create(data,
                userApplication.findUserByName(user.getName()).get());
        return calendar != null ?
                ResponseEntity.ok(
                        calendarToCalendarResourceMapper.apply(calendar)) :
                ResponseEntity.badRequest().build();

    }
}
