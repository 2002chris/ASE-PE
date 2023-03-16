package de.dhbw.ase.plugins.persistence.hibernate.user;

import de.dhbw.ase.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByName(String name);
}
