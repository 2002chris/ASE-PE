package de.dhbw.ase.domain.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {

    List<Tag> findAllTags();

    Optional<Tag> findTagByName(String name);

    Tag save(Tag tag);
}
