package de.dhbw.ase.rest;

import de.dhbw.ase.adapter.todo.TodoResource;
import de.dhbw.ase.adapter.todo.TodoToTodoResourceMapper;
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
    private final TodoApplicationService todoApplicationService;
    private final TodoToTodoResourceMapper todoToTodoResourceMapper;

    @Autowired
    public TodoController(final TodoApplicationService todoApplicationService, final TodoToTodoResourceMapper todoToTodoResourceMapper) {
        this.todoApplicationService = todoApplicationService;
        this.todoToTodoResourceMapper = todoToTodoResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoResource> getTodos(){
        return this.todoApplicationService.findAllTodos().stream()
                .map(todoToTodoResourceMapper).collect(Collectors.toList());
    }
}
