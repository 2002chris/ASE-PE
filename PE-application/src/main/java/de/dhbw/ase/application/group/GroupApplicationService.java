package de.dhbw.ase.application.group;

import de.dhbw.ase.domain.group.Group;
import de.dhbw.ase.domain.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupApplicationService implements GroupApplication{
    private final GroupRepository groupRepository;

    @Autowired
    public GroupApplicationService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public List<Group> findAllGroups() {
        return this.groupRepository.findAllGroups();
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }
}
