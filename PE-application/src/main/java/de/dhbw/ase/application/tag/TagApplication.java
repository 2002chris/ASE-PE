package de.dhbw.ase.application.tag;

import de.dhbw.ase.domain.tag.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagApplication {
    List<Tag> findAllTags();

    Optional<Tag> findTagByName(String name);

    Tag save(Tag tag);

    Tag create(TagAttributeData data);

    boolean delete(String name);
}
