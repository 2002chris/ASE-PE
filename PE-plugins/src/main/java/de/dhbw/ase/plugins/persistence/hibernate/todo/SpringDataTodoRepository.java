package de.dhbw.ase.plugins.persistence.hibernate.todo;

import de.dhbw.ase.domain.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataTodoRepository extends JpaRepository<Todo, UUID> {
    public Optional<Todo> findTodoById(UUID id);

    @Query(value = "select * from todo where id = (select users_todos.todos_id from users right join users_todos on users.id = users_todos.user_id where users.name = ?1 )", nativeQuery = true)
    List<Todo> findUserTodos(String username);
}
