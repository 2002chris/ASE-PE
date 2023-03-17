package de.dhbw.ase.application.calendar;

import de.dhbw.ase.domain.calendar.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CalendarApplicationService implements CalendarApplication{

    private final CalendarApplication calendarApplication;

    @Autowired
    public CalendarApplicationService(final CalendarApplication calendarApplication, CalendarApplication calendarApplication1) {
        this.calendarApplication = calendarApplication1;
    }

    @Override
    public List<Calendar> findAllCalendars() {
        return calendarApplication.findAllCalendars();
    }

    @Override
    public Optional<Calendar> findCalendarById(UUID id) {
        return calendarApplication.findCalendarById(id);
    }

    @Override
    public Calendar save(Calendar calendar) {
        return calendarApplication.save(calendar);
    }
}
