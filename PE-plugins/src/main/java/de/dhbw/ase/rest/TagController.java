package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.tag.TagResource;
import de.dhbw.ase.adapter.tag.TagToTagResourceMapper;
import de.dhbw.ase.application.tag.TagApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/tag")
public class TagController {

    private final TagApplication tagApplication;
    private final TagToTagResourceMapper tagToTagResourceMapper;

    @Autowired
    public TagController(final TagApplication tagApplication, final TagToTagResourceMapper tagToTagResourceMapper) {
        this.tagApplication = tagApplication;
        this.tagToTagResourceMapper = tagToTagResourceMapper;
    }

    @GetMapping
    public List<TagResource> getTags() {
        return tagApplication.findAllTags().stream().map(tagToTagResourceMapper).collect(Collectors.toList());
    }
}
