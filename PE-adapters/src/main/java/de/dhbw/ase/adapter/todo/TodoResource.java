package de.dhbw.ase.adapter.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.calendar.Calendar;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class TodoResource {

    private final LocalDate untilDate;
    private final String content;
    private final Set<Tag> tags;
    private final Calendar calendar;

}
