package de.dhbw.ase.application.tag;

import de.dhbw.ase.domain.Tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagApplicationService implements TagApplication {

    private final TagApplication tagApplication;

    @Autowired
    public TagApplicationService(final TagApplication tagApplication) {
        this.tagApplication = tagApplication;
    }

    @Override
    public List<Tag> findAllTags() {
        return tagApplication.findAllTags();
    }

    @Override
    public Optional<Tag> findTagByName(String name) {
        return tagApplication.findTagByName(name);
    }

    @Override
    public Tag save(Tag tag) {
        return save(tag);
    }
}
