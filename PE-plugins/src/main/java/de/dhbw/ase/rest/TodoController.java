package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.todo.TodoResource;
import de.dhbw.ase.adapter.todo.TodoToTodoResourceMapper;
import de.dhbw.ase.application.todo.TodoApplication;
import de.dhbw.ase.application.todo.TodoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoResource> getTodos(){
        return this.todoApplication.findAllTodos().stream()
                .map(todoToTodoResourceMapper).collect(Collectors.toList());
    }
}
