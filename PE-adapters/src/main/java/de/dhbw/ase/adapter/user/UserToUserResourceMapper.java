package de.dhbw.ase.adapter.user;

import de.dhbw.ase.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToUserResourceMapper implements Function<User, UserResource> {
    @Override
    public UserResource apply(User user) {
        return map(user);
    }

    public UserResource map(User user){
        return new UserResource(user.getName(), user.getPassword(),
                user.getTodos(), user.getCalendars());
    }
}
