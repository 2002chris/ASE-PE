package de.dhbw.ase.domain.group;

import de.dhbw.ase.domain.todo.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GroupRepository {

        List<Group> findAllGroups();

        Optional<Group> findGroupById(UUID uuid);

        Group save(Group group);

}
