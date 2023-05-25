package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.user.UserResource;
import de.dhbw.ase.adapter.user.UserToUserResourceMapper;
import de.dhbw.ase.application.user.UserApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserApplication userApplication;
    private final UserToUserResourceMapper userToUserResourceMapper;

    public UserController(UserApplication userApplication, UserToUserResourceMapper userToUserResourceMapper) {
        this.userApplication = userApplication;
        this.userToUserResourceMapper = userToUserResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserResource> getAllUser() {
        return userApplication.findAllUsers().stream().map(userToUserResourceMapper).collect(Collectors.toList());
    }

    @GetMapping(params = {"name"})
    public UserResource getUserByName(@RequestParam(name = "name") String name) {
        return userApplication.findUserByName(name).stream().map(userToUserResourceMapper).findFirst().get();
    }
}
