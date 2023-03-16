package de.dhbw.ase.adapter.group;

import de.dhbw.ase.domain.group.Group;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;


public class GroupToGroupResourceMapper implements Function<Group, GroupResource> {

    @Override
    public GroupResource apply(Group group) {
        return map(group);
    }

    public GroupResource map(Group group){
        return new GroupResource(group.getUsers(), group.getTodos());
    }
}
