package de.dhbw.ase.application.tag;

import de.dhbw.ase.domain.Tag.Tag;
import de.dhbw.ase.domain.Tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagApplicationService implements TagApplication {

    private final TagRepository tagRepository;

    @Autowired
    public TagApplicationService(final TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAllTags();
    }

    @Override
    public Optional<Tag> findTagByName(String name) {
        return tagRepository.findTagByName(name);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
}
