package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
import de.dhbw.ase.domain.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TodoApplicationServiceTest {

    @Mock
    private TodoRepository repository;
    @InjectMocks
    private TodoApplicationService applicationService;

    private Todo entity = new Todo(LocalDate.now(), "test1", new ArrayList<>() {{add(new Tag("test1"));}});

    private User user = new User("test", "1234", new ArrayList<>(){{add(entity);}}, new ArrayList<>());

    private List<Todo> entities = new ArrayList<>(){{add(entity);}};

    @Before
    public void setup(){
        when(repository.save(entity)).thenReturn(entity);
        when(repository.findTodoById(entity.getId())).thenReturn(Optional.of(entity));
        when(repository.findAllTodos()).thenReturn(entities);
        when(repository.findUserTodos(user.getName())).thenReturn(user.getTodos());
    }

    @Test
    public void testSave(){
        Todo result = applicationService.save(entity);
        checkEntity(entity,result);
        verify(repository).save(entity);
    }

    @Test
    public void testFindTodoById(){
        Optional<Todo> result = applicationService.findTodoById(entity.getId());
        assertTrue(result.isPresent());
        checkEntity(entity, result.get());
        verify(repository).findTodoById(entity.getId());
    }

    @Test
    public void testFindAllTodos(){
        List<Todo> results = applicationService.findAllTodos();
        assertEquals(1, results.size());
        Todo todo = results.get(0);
        checkEntity(entity, todo);
        verify(repository).findAllTodos();
    }

    @Test
    public void testFindUserTodos(){
        List<Todo> results = applicationService.findUserTodos(user.getName());
        assertEquals(1, results.size());
        assertEquals(user.getTodos(), results);
        verify(repository).findUserTodos(user.getName());
    }

    public void checkEntity(Todo expected, Todo actual){
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getContent(), actual.getContent());
        assertEquals(expected.getUntilDate(), actual.getUntilDate());
        assertEquals(expected.getTags(), actual.getTags());
    }

}
