package de.dhbw.ase.adapter.calendar;

import de.dhbw.ase.domain.calendar.Calendar;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CalendarToCalendarResourceMapper implements Function<Calendar, CalendarResource> {

    @Override
    public CalendarResource apply(Calendar calendar) {
        return map(calendar);
    }

    private CalendarResource map(Calendar calendar) {
        return new CalendarResource(calendar.getTodos(),calendar.getReminder());
    }
}
