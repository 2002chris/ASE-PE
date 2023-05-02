package de.dhbw.ase.application.user;

import de.dhbw.ase.application.user.UserApplicationService;
import de.dhbw.ase.domain.calendar.Calendar;
import de.dhbw.ase.domain.todo.Todo;
import de.dhbw.ase.domain.user.User;
import de.dhbw.ase.domain.user.UserRepository;
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
public class UserApplicationServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserApplicationService applicationService;

    private final String name = "user1";
    private final String password = "1234";

    private final Todo todo = new Todo(LocalDate.now(), "todo1", new ArrayList<>());
    private final Calendar calendar = new Calendar(new ArrayList<>(), new ArrayList<>(), "calendar");

    private final User entity = new User(name, password, new ArrayList<>() {{
        add(todo);
    }}, new ArrayList<>() {{
        add(calendar);
    }});

    private final List<User> entities = new ArrayList<>() {{
        add(entity);
    }};

    @Before
    public void setup() {
        when(repository.findUserById(entity.getId())).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(entity);
        when(repository.findUserByName(entity.getName())).thenReturn(Optional.of(entity));
        when(repository.findAllUsers()).thenReturn(entities);
    }

    @Test
    public void testFindUserById() {
        Optional<User> result = applicationService.findUserById(entity.getId());
        assertTrue(result.isPresent());
        checkEntity(entity, result.get());
        verify(repository).findUserById(entity.getId());
    }

    @Test
    public void testSave() {
        User result = applicationService.save(entity);
        checkEntity(entity, result);
        verify(repository).save(entity);
    }

    @Test
    public void testFindUserByName() {
        Optional<User> result = applicationService.findUserByName(name);
        assertTrue(result.isPresent());
        checkEntity(entity, result.get());
        verify(repository).findUserByName(name);
    }

    @Test
    public void testFindAllUsers() {
        List<User> results = applicationService.findAllUsers();
        assertEquals(1, results.size());
        User result = results.get(0);
        checkEntity(entity, result);
        verify(repository).findAllUsers();
    }

    private void checkEntity(User expectedEntity, User actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getCalendars(), actualEntity.getCalendars());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getTodos(), actualEntity.getTodos());
        assertEquals(expectedEntity.getPassword(), actualEntity.getPassword());
    }
}
