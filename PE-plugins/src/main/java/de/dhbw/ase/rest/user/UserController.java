package de.dhbw.ase.rest.user;

import de.dhbw.ase.adapter.user.UserResource;
import de.dhbw.ase.adapter.user.UserToUserResourceMapper;
import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResource> create(@RequestBody UserData data){
        if (data.getPassword() != null && data.getName() != null) {
            User tempUser = userApplication.create(data);
            if (tempUser != null){
                return ResponseEntity.ok(userToUserResourceMapper.apply(tempUser));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping()
    public ResponseEntity<UserResource> update(@RequestBody UserData data, Principal user){
        User temp = userApplication.update(data, user.getName());
        return ResponseEntity.ok(userToUserResourceMapper.apply(temp));
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<Void> delete(@RequestParam String id){
        return userApplication.delete(UUID.fromString(id)) ?
                ResponseEntity.ok().build() :
                ResponseEntity.badRequest().build();
    }
}
