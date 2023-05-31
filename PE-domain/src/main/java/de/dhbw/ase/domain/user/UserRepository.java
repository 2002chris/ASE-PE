package de.dhbw.ase.domain.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    List<User> findAllUsers();

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByName(String name);

    User save(User user);

    void delete(User user);
}
