//package com.example.ToDo.Controller;
//
//public class RestTemplateController {
//}
// RestTemplateController.java
package com.example.ToDo.Controller;

import com.example.ToDo.Model.Todo;
import com.example.ToDo.Service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resttemplate")
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return restTemplateService.getAllTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") Integer id) {
        return restTemplateService.getTodoById(id);
    }

    @GetMapping("/status/{completed}")
    public List<Todo> getAllTodosByCompleted(@PathVariable("completed") boolean completed)
    {
        return restTemplateService.getAllTodosByCompleted(completed);
    }
}
