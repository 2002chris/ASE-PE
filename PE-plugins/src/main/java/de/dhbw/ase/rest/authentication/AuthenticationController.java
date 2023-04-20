package de.dhbw.ase.rest.authentication;

import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private final UserApplication userApplication;

    @Autowired
    public AuthenticationController(final UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @PostMapping(path = "/auth/login")
    public ResponseEntity<?> login(Principal user){
        User unauthorizedUser;
        try{
            unauthorizedUser = userApplication.findUserByName(user.getName()).get();
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }

        return unauthorizedUser.getPassword().equals(user.getName()) ? new ResponseEntity<>(HttpStatus.ACCEPTED) : new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
    }
}
