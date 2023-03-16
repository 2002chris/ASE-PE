package de.dhbw.ase.adapter.group;

import de.dhbw.ase.domain.group.Group;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class GroupToGroupResourceMapper implements Function<Group, GroupResource> {

    @Override
    public GroupResource apply(Group group) {
        return map(group);
    }

    public GroupResource map(Group group){
        return new GroupResource(group.getUsers(), group.getTodos());
    }
}
