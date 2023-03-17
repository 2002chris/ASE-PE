package de.dhbw.ase.domain.group;

import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @Type(type="uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "users")
    @OneToMany
    private List<User> users;

    @Column(name = "todos")
    @OneToMany
    private List<Todo> todos;

    public Group(List<User> users, List<Todo> todos) {
        this.id = UUID.randomUUID();
        this.users = users;
        this.todos = todos;
    }
}
