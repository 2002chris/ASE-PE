package de.dhbw.ase.adapter.user;

import lombok.Getter;

@Getter
public class UserResource implements UserResourceInterface {

    private final String name;
    private final String password;

    public UserResource(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
