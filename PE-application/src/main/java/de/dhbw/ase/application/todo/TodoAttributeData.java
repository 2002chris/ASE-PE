package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.Tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class TodoAttributeData {
    private LocalDate untilDate;
    private String content;
    private List<Tag> tags;
    private UUID calendarId;

//    public TodoAttributeData(String s_untilDate, String content, List<Tag> tags, UUID calendarId) {
//        this.untilDate = LocalDate.parse(s_untilDate);
//        this.content = content;
//        this.tags = tags;
//        this.calendarId = calendarId;
//    }
}
