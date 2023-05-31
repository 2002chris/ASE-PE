package de.dhbw.ase.rest.tag;

import de.dhbw.ase.adapter.tag.TagResource;
import de.dhbw.ase.adapter.tag.TagToTagResourceMapper;
import de.dhbw.ase.application.tag.TagApplication;
import de.dhbw.ase.application.tag.TagAttributeData;
import de.dhbw.ase.domain.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
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

    @PostMapping()
    public ResponseEntity<TagResource> create(@RequestBody TagData data){
        Tag tag = tagApplication.create(data);
        return tag != null ?
                ResponseEntity.ok(tagToTagResourceMapper.apply(tag)):
                ResponseEntity.badRequest().build();

    }

    @DeleteMapping(params = {"name"})
    public ResponseEntity<Void> delete(@RequestParam String name){
        return tagApplication.delete(name)?
                ResponseEntity.ok().build():
                ResponseEntity.badRequest().build();
    }
}
