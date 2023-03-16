package de.dhbw.ase.application.group;

import de.dhbw.ase.domain.group.Group;
import de.dhbw.ase.domain.group.GroupRepository;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupApplicationService implements GroupApplication{
    private final GroupRepository groupRepository;

    @Autowired
    public GroupApplicationService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public List<Group> findAllGroups() {
        return this.groupRepository.findAllGroups();
    }

    @Override
    public Group save(Group group) {
        return this.groupRepository.save(group);
    }

    @Override
    public void addUserToGroup(User user, Group group) {
        //TODO refactor to generic method in abstraction layer

        List<User> users = group.getUsers();
        users.add(user);
        group.setUsers(users);
        this.groupRepository.save(group);
    }

    @Override
    public void addTodoToGroup(Todo todo, Group group){
        List<Todo> todos = group.getTodos();
        todos.add(todo);
        group.setTodos(todos);
        this.groupRepository.save(group);
    }
}
