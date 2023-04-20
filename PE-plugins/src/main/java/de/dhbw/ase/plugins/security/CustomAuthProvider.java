package de.dhbw.ase.plugins.security;

import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.plugins.persistence.hibernate.user.UserRepositoryBridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private UserApplication userApplication;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (userApplication.findUserByName(userName).isPresent()){

                if(password.equals(userApplication.findUserByName(userName).get().getPassword())) {
                return new UsernamePasswordAuthenticationToken(userName, password,
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
            }
        }
        throw new AuthenticationServiceException("");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
