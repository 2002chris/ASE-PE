package de.dhbw.ase.adapter.calendar;

import lombok.Getter;

@Getter
public class CalendarResource {

    private final String name;

    public CalendarResource(String name) {
        this.name = name;
    }
}
