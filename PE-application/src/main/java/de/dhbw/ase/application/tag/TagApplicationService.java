package de.dhbw.ase.application.tag;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Tag create(TagAttributeData data) {
        return !tagRepository.existsById(data.getName()) ? save(new Tag(data.getName())) : null;
    }

    @Override
    public boolean delete(String name) {
        Tag tag = tagRepository.findTagByName(name).orElse(null);
        if (tag != null) {
            tagRepository.delete(tag);
            return true;
        }
        return false;
    }
}
