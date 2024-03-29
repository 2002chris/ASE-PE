package de.dhbw.ase.rest.todo;

import de.dhbw.ase.adapter.todo.TodoResource;
import de.dhbw.ase.adapter.todo.TodoToTodoResourceMapper;
import de.dhbw.ase.application.todo.TodoApplication;
import de.dhbw.ase.application.user.UserApplication;
import de.dhbw.ase.domain.tag.Tag;
import de.dhbw.ase.domain.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/todo")
public class TodoController {
    private final TodoApplication todoApplication;
    private final UserApplication userApplication;
    private final TodoToTodoResourceMapper todoToTodoResourceMapper;

    @Autowired
    public TodoController(final TodoApplication todoApplication, final TodoToTodoResourceMapper todoToTodoResourceMapper,
                          final UserApplication userApplication) {
        this.todoApplication = todoApplication;
        this.todoToTodoResourceMapper = todoToTodoResourceMapper;
        this.userApplication = userApplication;
    }

    @GetMapping()
    public List<TodoResource> getTodos(Principal user) {
        return this.todoApplication.findTodoByUser(userApplication.findUserByName(user.getName()).get()).stream()
                .map(todoToTodoResourceMapper).collect(Collectors.toList());
    }

    @GetMapping(params = {"id"})
    public TodoResource getTodo(@RequestParam(name = "id") String id) {
        return this.todoApplication.findTodoById(UUID.fromString(id))
                .stream().map(todoToTodoResourceMapper).findFirst().get();
    }

    @GetMapping(params = {"tags"})
    public List<TodoResource> getTodoByTags(@RequestParam(name = "tags") List<Tag> tags) {
        return this.todoApplication.findTodoByTags(tags).stream().map(todoToTodoResourceMapper)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<TodoResource> create(@RequestBody TodoData data, Principal user) {
        return ResponseEntity.ok(
                todoToTodoResourceMapper.apply(
                        todoApplication.create(data, userApplication.findUserByName(user.getName()).get())));

    }

    @PutMapping(params = {"id"})
    public ResponseEntity<TodoResource> update(@RequestBody TodoData data,
                                               @RequestParam String id){
        Todo todo =  todoApplication.update(data,
                UUID.fromString(id));
        return todo != null ? ResponseEntity.ok(todoToTodoResourceMapper.apply(todo)) :
                ResponseEntity.badRequest().build();
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<Void> delete(@RequestParam String id){
        return todoApplication.delete(UUID.fromString(id)) ?
                ResponseEntity.ok().build() :
                ResponseEntity.badRequest().build();

    }
}
