package de.dhbw.ase.plugins.persistence.hibernate.calendar;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.calendar.CalendarRepository;
import de.dhbw.ase.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CalendarRepositoryBridge implements CalendarRepository {
    private final SpringDataCalendarRepository springDataCalendarRepository;

    public CalendarRepositoryBridge(final SpringDataCalendarRepository springDataCalendarRepository) {
        this.springDataCalendarRepository = springDataCalendarRepository;
    }

    @Override
    public List<Calendar> findAllCalendars() {
        return springDataCalendarRepository.findAll();
    }

    @Override
    public Optional<Calendar> findCalendarById(UUID uuid) {
        return springDataCalendarRepository.findCalendarById(uuid);
    }

    @Override
    public Calendar save(Calendar calendar) {
        return springDataCalendarRepository.save(calendar);
    }

    @Override
    public Optional<Calendar> getCalendarById(UUID calendarId) {
        return springDataCalendarRepository.findCalendarById(calendarId);
    }

    @Override
    public List<Calendar> findCalendarsByUser(User user) {
        return springDataCalendarRepository.findCalendarsByUser(user);
    }


}
