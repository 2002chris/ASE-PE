package de.dhbw.ase.plugins.persistence.hibernate.todo;

import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataTodoRepository extends JpaRepository<Todo, UUID> {
    Optional<Todo> findTodoById(UUID id);

//    @Query(value = "select * from todo where id = (select users_todos.todos_id from users right join users_todos on users.id = users_todos.user_id where users.name = ?1 )", nativeQuery = true)
//    List<Todo> findUserTodos(String username);

    List<Todo> findByUser(User user);

    List<Todo> findByTagsIn(List<Tag> tags);

    List<Todo> findTodosByCalendar(Calendar calendar);
}
