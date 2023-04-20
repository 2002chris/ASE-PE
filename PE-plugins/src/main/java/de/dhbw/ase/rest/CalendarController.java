package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.calendar.CalendarResource;
import de.dhbw.ase.adapter.calendar.CalendarToCalendarResourceMapper;
import de.dhbw.ase.application.calendar.CalendarApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api/calendar")
public class CalendarController
{
    private final CalendarApplication calendarApplication;
    private final CalendarToCalendarResourceMapper calendarToCalendarResourceMapper;

    @Autowired
    public CalendarController(final CalendarApplication calendarApplication, final CalendarToCalendarResourceMapper calendarToCalendarResourceMapper)
    {
        this.calendarApplication = calendarApplication;
        this.calendarToCalendarResourceMapper = calendarToCalendarResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CalendarResource> getCalendars(){
        return calendarApplication.findAllCalendars().stream().map(calendarToCalendarResourceMapper).collect(Collectors.toList());
    }

    @GetMapping(params = {"id"})
    public CalendarResource getCalendar(String id){
        return calendarApplication.findCalendarById(UUID.fromString(id)).stream().map(calendarToCalendarResourceMapper).findFirst().get();
    }
}
