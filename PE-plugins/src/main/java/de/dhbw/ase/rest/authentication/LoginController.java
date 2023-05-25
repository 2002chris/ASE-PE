package de.dhbw.ase.rest.authentication;

import de.dhbw.ase.application.user.UserApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/auth")
public class LoginController {

    private final UserApplication userApplication;

    @Autowired
    public LoginController(final UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @GetMapping
    public ResponseEntity<?> login(Principal user) {

        return user != null ? new ResponseEntity<>(HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
