package de.dhbw.ase.application.user;

import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserAttributeData {
    private String name;
    private String password;

}
