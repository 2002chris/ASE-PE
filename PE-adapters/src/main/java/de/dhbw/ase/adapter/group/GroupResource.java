package de.dhbw.ase.adapter.group;

import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public class GroupResource {

    private List<User> users;
    private List<Todo> todos;

    public GroupResource(final List<User> users, final List<Todo> todos) {
        this.users = users;
        this.todos = todos;
    }
}
