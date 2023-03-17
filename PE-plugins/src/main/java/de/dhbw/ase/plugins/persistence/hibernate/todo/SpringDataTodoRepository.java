package de.dhbw.ase.plugins.persistence.hibernate.todo;

import de.dhbw.ase.domain.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataTodoRepository extends JpaRepository<Todo, UUID> {
    public Optional<Todo> findTodoById(UUID id);
}
