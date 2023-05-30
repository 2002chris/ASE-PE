package de.dhbw.ase.domain.calendar;

import de.dhbw.ase.domain.user.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CalendarRepository {

    List<Calendar> findAllCalendars();

    Optional<Calendar> findCalendarById(UUID uuid);

    Calendar save(Calendar calendar);

    Optional<Calendar> getCalendarById(UUID calendarId);

    List<Calendar> findCalendarsByUser(User user);
}
