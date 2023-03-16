package de.dhbw.ase.application.group;

import de.dhbw.ase.domain.group.Group;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;

import java.util.List;

public interface GroupApplication {
    Group save(Group group);
    void addUserToGroup(User user, Group group);

    List<Group> findAllGroups();

    void addTodoToGroup(Todo todo, Group group);
}
