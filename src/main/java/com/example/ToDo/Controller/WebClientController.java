package com.example.ToDo.Controller;

import com.example.ToDo.Model.Todo;
import com.example.ToDo.Service.RestClientService;
import com.example.ToDo.Service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/webcontroller")
public class WebClientController
{
    private final WebClientService todoService;

    @Autowired
    public WebClientController(WebClientService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") Integer id)
    {
        return todoService.getTodoById(id);
    }
    @GetMapping("/status/{completed}")
    public List<Todo> getAllTodosByCompleted(@PathVariable("completed") boolean status) {
        return todoService.getAllTodosByCompleted(status);
    }
}
