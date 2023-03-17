package de.dhbw.ase.plugins.persistence.hibernate.calendar;

import de.dhbw.ase.domain.calendar.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataCalendarRepository extends JpaRepository<Calendar, UUID> {
    Optional<Calendar> findCalendarById(UUID id);
}
