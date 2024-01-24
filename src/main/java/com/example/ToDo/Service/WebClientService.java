package com.example.ToDo.Service;

import com.example.ToDo.Model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service

public class WebClientService
{
    private final WebClient webClient;
    public WebClientService()
    {
        this.webClient=WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com/todos/").build();
    }
    public List<Todo> getAllTodos()

    {
        return webClient.get().uri("").retrieve().bodyToMono(List.class).block();
    }
    public Todo getTodoById(Integer id)
    {
        return webClient.get().uri(""+id).retrieve().bodyToMono(Todo.class).block();
    }

    public List<Todo> getAllTodosByCompleted(boolean completed)
    {
        return webClient.get().uri(usiBuilder->usiBuilder.path("").queryParam("completed",completed).build()).retrieve().bodyToMono(List.class).block();
    }
}
