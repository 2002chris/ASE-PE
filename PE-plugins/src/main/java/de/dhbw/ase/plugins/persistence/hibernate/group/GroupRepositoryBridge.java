package de.dhbw.ase.plugins.persistence.hibernate.group;

import de.dhbw.ase.domain.group.Group;
import de.dhbw.ase.domain.group.GroupRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GroupRepositoryBridge implements GroupRepository {

    SpringDataGroupRepository springDataGroupRepository;
    @Override
    public List<Group> findAllGroups() {
        return springDataGroupRepository.findAll();
    }

    @Override
    public Optional<Group> findGroupById(UUID uuid) {
        return springDataGroupRepository.findGroupById(uuid);
    }

    @Override
    public Group save(Group group) {
        return null;
    }
}
