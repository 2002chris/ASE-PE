package de.dhbw.ase.plugins.persistence.hibernate.user;

import de.dhbw.ase.domain.user.User;
import de.dhbw.ase.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryBridge implements UserRepository {
    private final SpringDataUserRepository springDataUserRepository;

    public UserRepositoryBridge(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return springDataUserRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return springDataUserRepository.findUserById(id);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return springDataUserRepository.findUserByName(name);
    }

    @Override
    public User save(User user) {
        return springDataUserRepository.save(user);
    }

    @Override
    public void delete(User user) {
        springDataUserRepository.delete(user);
    }
}
