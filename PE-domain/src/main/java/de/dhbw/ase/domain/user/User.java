package de.dhbw.ase.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "password")
    private String password;
    @Id
    @Type(type = "uuid-char")
    @Column(name = "user_id")
    private UUID id;

    public User(){
        this.id = UUID.randomUUID();
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.id = UUID.randomUUID();
    }
}
