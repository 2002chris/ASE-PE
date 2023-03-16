package de.dhbw.ase.domain.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    List<User> findAllUsers();

    Optional<User> findUserById(UUID id);

    List<User> findUserByName(String name);
    User save(User user);
}
