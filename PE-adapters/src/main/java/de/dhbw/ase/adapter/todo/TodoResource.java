package de.dhbw.ase.adapter.todo;

import de.dhbw.ase.domain.Tag.Tag;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class TodoResource {

    private LocalDate untilDate;
    private String content;
//    private List<Tag> tags;

    public TodoResource(final LocalDate untilDate, final String content
//            , final List<Tag> tags
            ){
        this.untilDate = untilDate;
        this.content = content;
//        this.tags = tags;
    }
}
