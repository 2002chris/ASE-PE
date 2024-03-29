package de.dhbw.ase.plugins.persistence.hibernate.tag;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.tag.TagRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagRepositoryBridge implements TagRepository {
    private final SpringDataTagRepository springDataTagRepository;

    public TagRepositoryBridge(final SpringDataTagRepository springDataTagRepository) {
        this.springDataTagRepository = springDataTagRepository;
    }

    @Override
    public List<Tag> findAllTags() {
        return springDataTagRepository.findAll();
    }

    @Override
    public Optional<Tag> findTagByName(String name) {
        return springDataTagRepository.findTagByName(name);
    }

    @Override
    public Tag save(Tag tag) {
        return springDataTagRepository.save(tag);
    }

    public boolean existsById(String id){
        return springDataTagRepository.existsById(id);
    }

    public void delete(Tag tag){
        springDataTagRepository.delete(tag);
    }
}
