package de.dhbw.ase.application.user;

import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationService implements UserApplication {

    private final UserApplication userApplication;

    @Autowired
    public UserApplicationService(final UserApplication userApplication){
        this.userApplication = userApplication;
    }

    @Override
    public List<User> findAllUsers() {
        return userApplication.findAllUsers();
    }

    @Override
    public User save(User user) {
        return userApplication.save(user);
    }
}
