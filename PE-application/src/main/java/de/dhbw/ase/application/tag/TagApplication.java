package de.dhbw.ase.application.tag;

import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.reminder.Reminder;

import java.util.List;
import java.util.Optional;

public interface TagApplication {
    List<Tag> findAllTags();
    Optional<Tag> findTagByName(String name);
    Tag save(Tag tag);
}
