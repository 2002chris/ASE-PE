package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.todo.TodoResource;
import de.dhbw.ase.adapter.todo.TodoToTodoResourceMapper;
import de.dhbw.ase.application.todo.TodoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/todo")
public class TodoController {
    private final TodoApplication todoApplication;
    private final TodoToTodoResourceMapper todoToTodoResourceMapper;

    @Autowired
    public TodoController(final TodoApplication todoApplication, final TodoToTodoResourceMapper todoToTodoResourceMapper) {
        this.todoApplication = todoApplication;
        this.todoToTodoResourceMapper = todoToTodoResourceMapper;
    }

    @GetMapping
    public List<TodoResource> getTodos(){
        return this.todoApplication.findAllTodos().stream()
                .map(todoToTodoResourceMapper).collect(Collectors.toList());
    }

    @GetMapping(params = {"id"})
    public TodoResource getTodo(@RequestParam String id){
        return this.todoApplication.findTodoById(UUID.fromString(id))
                .stream().map(todoToTodoResourceMapper).findFirst().get();
    }
}
