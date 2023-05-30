package de.dhbw.ase.plugins.persistence.hibernate.tag;

import de.dhbw.ase.domain.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataTagRepository extends JpaRepository<Tag, String> {
    Optional<Tag> findTagByName(String name);
}
