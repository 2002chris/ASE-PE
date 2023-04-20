package de.dhbw.ase.plugins.security;

import de.dhbw.ase.plugins.security.AuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;


    private final CustomAuthProvider customAuthProvider;

    @Autowired
    public WebSecurityConfig(CustomAuthProvider customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthProvider);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                    .antMatchers("/auth/*").permitAll()
                .anyRequest().authenticated();
        return http.build();
    }

    protected SecurityFilterChain filterChain2(HttpSecurity http) throws Exception{
     return null;
    }

}
