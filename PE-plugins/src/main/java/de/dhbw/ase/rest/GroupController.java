package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.group.GroupResource;
import de.dhbw.ase.adapter.group.GroupToGroupResourceMapper;
import de.dhbw.ase.application.group.GroupApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/group")
public class GroupController {

    private final GroupApplication groupApplication;
    private final GroupToGroupResourceMapper groupToGroupResourceMapper;

    @Autowired
    public GroupController(final GroupApplication groupApplication,final GroupToGroupResourceMapper groupToGroupResourceMapper) {
        this.groupApplication = groupApplication;
        this.groupToGroupResourceMapper = groupToGroupResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GroupResource> getGroups(){
        return this.groupApplication.findAllGroups().stream()
                .map(groupToGroupResourceMapper).collect(Collectors.toList());
    }
}
