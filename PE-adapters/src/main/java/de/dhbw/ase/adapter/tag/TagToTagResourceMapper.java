package de.dhbw.ase.adapter.tag;

import de.dhbw.ase.domain.Tag.Tag;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TagToTagResourceMapper implements Function<Tag, TagResource> {
    @Override
    public TagResource apply(Tag tag) {
        return map(tag);
    }

    private TagResource map(Tag tag) {
        return new TagResource(tag.getName());
    }
}
