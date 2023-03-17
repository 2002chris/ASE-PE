package de.dhbw.ase.application.calendar;

import de.dhbw.ase.domain.calendar.Calendar;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CalendarApplication {
    List<Calendar> findAllCalendars();

    Optional<Calendar> findCalendarById(UUID id);

    Calendar save(Calendar calendar);
}
