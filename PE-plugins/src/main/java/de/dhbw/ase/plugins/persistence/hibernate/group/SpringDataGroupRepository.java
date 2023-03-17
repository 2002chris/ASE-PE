package de.dhbw.ase.plugins.persistence.hibernate.group;

import de.dhbw.ase.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataGroupRepository extends JpaRepository<Group, UUID> {
    public Optional<Group> findGroupById(UUID id);
}
