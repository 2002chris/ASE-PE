package de.dhbw.ase.application.todo;

import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.todo.TodoRepository;
import de.dhbw.ase.domain.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
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

    private User user = new User("test", "1234");
    private Todo entity = new Todo(LocalDate.now(), "test1", new HashSet<>() {{add(new Tag("test1"));}},user, null);
    private Todo entity2 = new Todo(LocalDate.now(), "test2", new HashSet<>(), user, null);


    private List<Todo> entities = new ArrayList<>(){{add(entity); add(entity2);}};

    @Before
    public void setup(){
        when(repository.save(entity)).thenReturn(entity);
        when(repository.findTodoById(entity.getId())).thenReturn(Optional.of(entity));
        when(repository.findAllTodos()).thenReturn(entities);
        when(repository.findTodoByUser(user)).thenReturn(entities);
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
        assertEquals(2, results.size());
        Todo todo = results.get(0);
        checkEntity(entity, todo);
        verify(repository).findAllTodos();
    }

    @Test
    public void testFindTodoByUser(){
        List<Todo> results = applicationService.findTodoByUser(user);
        assertEquals(2, results.size());
        assertEquals(entities, results);
        verify(repository).findTodoByUser(user);
    }

    @Test
    public void testDelete(){
        Assertions.assertTrue(applicationService.delete(entity.getId()));
        verify(repository).delete(entity);
    }

    public void checkEntity(Todo expected, Todo actual){
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getContent(), actual.getContent());
        assertEquals(expected.getUntilDate(), actual.getUntilDate());
        assertEquals(expected.getTags(), actual.getTags());
        assertEquals(expected.getCalendar(), actual.getCalendar());
        assertEquals(expected.getUser(), actual.getUser());
    }


}
