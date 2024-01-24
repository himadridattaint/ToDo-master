package com.example.ToDo.Service;

import com.example.ToDo.Model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestClientService
{

    private final RestClient restClient;

        public RestClientService()
        {
            restClient=RestClient.builder().baseUrl("https://jsonplaceholder.typicode.com/todos").build();
        }
        public List<Todo> getAllTodos()

        {
            return restClient.get().uri("").retrieve().body(List.class);
        }
        public Todo getTodoById(Integer id)
        {
            return restClient.get().uri("/" + id).retrieve().body(Todo.class);
        }

        public List<Todo> getAllTodosByCompleted(boolean completed)
        {
            return restClient.get().uri(usiBuilder->usiBuilder.path("").queryParam("completed",completed).build()).retrieve().body(List.class);
        }
}
